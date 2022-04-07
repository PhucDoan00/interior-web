package doan.backend.service;

import java.util.List;

import doan.backend.dto.CartItemDTO;

public interface CartService {

	int addProductToCart(long customerId, long productId, int quantity);
	
	CartItemDTO findItemInCart(long cartId, long productId);
	
	List<CartItemDTO> getItemsInCart(long cartId);
}

