package doan.backend.dto;
import java.util.List;

import lombok.Data;

@Data
public class ShoppingCartDTO {

	private List<CartItemDTO> cartItem;
	private String name;
	private String phone;
	private String email;
	private String address;
	private float productTotal;
	private float shippingFee;
	
	public void setProductTotal(float productTotal) {
		this.productTotal = productTotal;
	}

	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}

	public ShoppingCartDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<CartItemDTO> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItemDTO> cartItem) {
		this.cartItem = cartItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getProductTotal() {
		return productTotal;
	}

	public float getShippingFee() {
		return shippingFee;
	}

}
