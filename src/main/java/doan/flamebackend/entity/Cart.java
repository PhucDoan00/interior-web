package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", nullable = false)
	private long cartId;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account customerId;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "address", nullable = false)
	private String address;
	@ManyToOne
	@JoinColumn(name = "cart_status", nullable = false)
	private Cart cartStatus;

	@ManyToMany(mappedBy = "product")
	private Collection<Product> products;

	public Cart() {

	}

	public Cart(long cartId, Account customerId, String phone, String email, String address, Cart cartStatus,
			Collection<Product> products) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.cartStatus = cartStatus;
		this.products = products;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Account getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Account customerId) {
		this.customerId = customerId;
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

	public Cart getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(Cart cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + ", cartStatus=" + cartStatus + ", products=" + products + "]";
	}

}
