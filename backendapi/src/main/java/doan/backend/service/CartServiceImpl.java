package doan.backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.backend.dto.CartItemDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Cart;
import doan.backend.entity.Product;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.CartRepository;
import doan.backend.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public CartItemDTO findItemInCart(long cartId, long productId) {
		Iterable<Object[]> data = cartRepository.findItemInCart(cartId, productId);
		ArrayList<CartItemDTO> result = new ArrayList<CartItemDTO>();
		data.forEach(item -> {
			CartItemDTO cartItem = new CartItemDTO();
			cartItem.setCartId(item[0] == null ? null : (Integer)item[0]);
			cartItem.setProductId(item[1] == null ? null : (Integer)item[1]);
			cartItem.setQuantity(item[2] == null ? null : (Integer)item[2]);
			cartItem.setPrice(item[3] == null ? null : (float)((double)item[3]));
			cartItem.setAddedAt((Date)item[4]);
			
			result.add(cartItem);
			}
		);
		Long i = result.get(0).getCartId();
		String s = i.toString();
		if (s.equals(null)) return null;
		return result.get(0);
	}
	
	@Override
	public List<CartItemDTO> getItemsInCart(long cartId) {
		Iterable<Object[]> data = cartRepository.getItemsInCart(cartId);
		ArrayList<CartItemDTO> result = new ArrayList<CartItemDTO>();
		data.forEach(item -> {
			CartItemDTO cartItem = new CartItemDTO();
			cartItem.setCartId(item[0] == null ? null : (Integer)item[0]);
			cartItem.setProductId(item[1] == null ? null : (Integer)item[1]);
			cartItem.setQuantity(item[2] == null ? null : (Integer)item[2]);
			cartItem.setPrice(item[3] == null ? null : (float)((double)item[3]));
			cartItem.setAddedAt((Date)item[4]);
			
			result.add(cartItem);
			}
		);
		return result;
	}
	
	@Override
	public int addProductToCart(long customerId, long productId, int quantity) {
		Account account = accountRepository.getById(customerId);
		Product product = productRepository.getOne(productId);
		if (cartRepository.countAvailableCart(customerId) == 0) {
			cartRepository.newCart(customerId, account.getPhone(), account.getEmail(), account.getAddress());
			Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
			cartRepository.insertCartItem(cart.getCartId(), productId, quantity, product.getPrice());
			return 0;
		}
		else {
			Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
			if (cartRepository.findAvailableItem(cart.getCartId(), productId) == 0) {
				cartRepository.insertCartItem(cart.getCartId(), productId, quantity, product.getPrice());
				return 0;
			} else {
				CartItemDTO cartItem = cartService.findItemInCart(cart.getCartId(), productId);
				if ((quantity + cartItem.getQuantity()) > product.getQuantity()) return 1;
				else {
					cartRepository.updateItemQuantity(quantity + cartItem.getQuantity(), cart.getCartId(), productId);
					return 0;
				}
			}
		}
		
	}
}
