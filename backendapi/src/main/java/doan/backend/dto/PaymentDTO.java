package doan.backend.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PaymentDTO {

	private List<CartItemDTO> cartItem;
	private String bankCode;
	private float totalPrice;
	private String content;
	
	public PaymentDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<CartItemDTO> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItemDTO> cartItem) {
		this.cartItem = cartItem;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
