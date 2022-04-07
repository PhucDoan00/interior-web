package doan.backend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.CartItemDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Bill;
import doan.backend.entity.Cart;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.BillRepository;
import doan.backend.repository.CartRepository;
import doan.backend.service.CartService;

@RestController
@RequestMapping("/api/v1")
public class BillController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@GetMapping("/checkout")
	public ResponseEntity<?> checkout(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
		long customerId = account.getAccountId();
		
		int count = cartRepository.countAvailableCart(customerId);
		
		if (count == 0) return new ResponseEntity<>("You need at least 1 item to checkout!", HttpStatus.BAD_REQUEST);
		else {
			Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
			List<CartItemDTO> items = cartService.getItemsInCart(cart.getCartId());
			Bill bill = new Bill();
			
			bill.setCartId(cart.getCartId());
			bill.setBillStatus((long)1);
			
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
			}
			bill.setProductTotal(result);
			
			float fee = (float) (result * 0.1);
			bill.setShippingFee((float)(Math.round(fee * 100.0) / 100.0));
			
			bill.setTotalPrice(bill.getProductTotal() + bill.getShippingFee());
			bill.setCustomerName(account.getName());
			bill.setPhone(cart.getPhone());
			bill.setEmail(cart.getEmail());
			bill.setAddress(cart.getAddress());
			java.util.Date date = new java.util.Date();   
			System.out.println(date);
			bill.setPurchasedAt(date);
		
			billRepository.save(bill);
			
			cartRepository.updateCartStatus(3, cart.getCartId());
		return new ResponseEntity<>("Purchase Successful!", HttpStatus.OK);
		}
	}
}
