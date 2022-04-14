package doan.backend.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.CartItemDTO;
import doan.backend.dto.ShoppingCartDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Cart;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.CartRepository;
import doan.backend.repository.ProductRepository;
import doan.backend.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
	
	private static final DecimalFormat dfZero = new DecimalFormat("0.00");

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getCartById(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account account = accountRepository.findByEmail(email);
    	long customerId = account.getAccountId();
		
		int count = cartRepository.countAvailableCart(customerId);
		
		if (count == 0) return new ResponseEntity<>("Your cart is empty!", HttpStatus.OK);
		else {
			Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
			List<CartItemDTO> items = cartService.getItemsInCart(cart.getCartId());
			
			ShoppingCartDTO finalCart = new ShoppingCartDTO();
			finalCart.setCartItem(items);
			finalCart.setName(account.getName());
			finalCart.setPhone(cart.getPhone());
			finalCart.setEmail(cart.getEmail());
			finalCart.setAddress(cart.getAddress());
			
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
			}
			finalCart.setProductTotal(result);
			double fee = result * 0.1;
			finalCart.setShippingFee(Float.parseFloat(dfZero.format(fee)));
			
			return new ResponseEntity<>(finalCart, HttpStatus.OK);
		}
	}

	@PostMapping("")
	public ResponseEntity<?> deleteItemFromCart(@RequestBody Long productId, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account account = accountRepository.findByEmail(email);
    	long customerId = account.getAccountId();
		Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
		
		if (cartRepository.findAvailableItem(cart.getCartId(), productId) == 0) return new ResponseEntity<>("Product not found", HttpStatus.OK);
		
		cartRepository.updateItemQuantity(0, cart.getCartId(), productId);
		int count = cartRepository.countItemsInCart(cart.getCartId());
		
		if (count == 0) {
			cartRepository.updateCartStatus(2, cart.getCartId());
		}
		return new ResponseEntity<>("Item removed!", HttpStatus.OK);
	}
	
	@PostMapping("/plus")
	public ResponseEntity<?> addQuantity(@RequestBody Long productId, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account account = accountRepository.findByEmail(email);
    	long customerId = account.getAccountId();
		
		Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
		if (cartRepository.findAvailableItem(cart.getCartId(), productId) == 0) return new ResponseEntity<>("Product not found", HttpStatus.OK);
		
		int quantityLeft = productRepository.getById(productId).getQuantity();
		CartItemDTO item = cartService.findItemInCart(cart.getCartId(), productId);
		int quantityCurrent = item.getQuantity();
		
		if (quantityCurrent + 1 > quantityLeft) {
			cartRepository.updateItemQuantity(quantityLeft, cart.getCartId(), productId);
			int count = cartRepository.countItemsInCart(cart.getCartId());
			System.out.println(count);
			if (count == 0) {
				cartRepository.updateCartStatus(2, cart.getCartId());
			}
			return new ResponseEntity<>("This product only has " + quantityLeft + " left!", HttpStatus.OK);
		} else cartRepository.updateItemQuantity(quantityCurrent + 1, cart.getCartId(), productId); 
		
		return new ResponseEntity<>("Item quantity added!", HttpStatus.OK);
	}
	
	@PostMapping("/minus")
	public ResponseEntity<?> minusQuantity(@RequestBody Long productId, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account account = accountRepository.findByEmail(email);
    	
    	long customerId = account.getAccountId();
		
		Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
		if (cartRepository.findAvailableItem(cart.getCartId(), productId) == 0) return new ResponseEntity<>("Product not found", HttpStatus.OK);
		
		int quantityLeft = productRepository.getById(productId).getQuantity();
		CartItemDTO item = cartService.findItemInCart(cart.getCartId(), productId);
		int quantityCurrent = item.getQuantity();
		
		if (quantityCurrent - 1 > quantityLeft) {
			cartRepository.updateItemQuantity(quantityLeft, cart.getCartId(), productId);
			int count = cartRepository.countItemsInCart(cart.getCartId());
			System.out.println(count);
			if (count == 0) {
				cartRepository.updateCartStatus(2, cart.getCartId());
			}
			return new ResponseEntity<>("This product only has " + quantityLeft + " left!", HttpStatus.OK);
		} else cartRepository.updateItemQuantity(quantityCurrent - 1, cart.getCartId(), productId); 
		
		
		return new ResponseEntity<>("Item quantity removed!", HttpStatus.OK);
	}
}
