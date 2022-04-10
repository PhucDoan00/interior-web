package doan.backend.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", nullable = false)
	private Long cartId;
	
	@Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@Column(name = "phone", length = 10, nullable = false)
	private String phone;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "cart_status", nullable = false)
	private Long cartStatus;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "cart_item",
			joinColumns = @JoinColumn(name = "cart_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private Set<Product> products;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false, insertable = false)
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_status", nullable = false, updatable = false, insertable = false)
	private CartStatus status;
	
	@OneToOne(mappedBy = "cart")
    private Bill bill;

	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
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

	public Long getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(Long cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
