package doan.backend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Bill")
public class Bill implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id", nullable = false)
	private Long billId;
	
	@Column(name = "cart_id", nullable = false)
	private Long cartId;
	
	@Column(name = "bill_status", nullable = false)
	private Long billStatus;
	
	@Column(name = "product_total", nullable = false)
	private float productTotal;
	
	@Column(name = "shipping_fee", nullable = false)
	private float shippingFee;
	
	@Column(name = "total_price", nullable = false)
	private float totalPrice;
	
	@Column(name = "customer_name", length = 100, nullable = false)
	private String customerName;
	
	@Column(name = "phone", length = 10, nullable = false)
	private String phone;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "address", length = 100, nullable = false)
	private String address;
	
	@Column(name = "purchased_at", nullable = false)
	private Date purchasedAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bill_status", nullable = false, updatable = false, insertable = false)
	private BillStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id", nullable = false, updatable = false, insertable = false)
    private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BillStatus getStatus() {
		return status;
	}

	public void setStatus(BillStatus status) {
		this.status = status;
	}

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(Long billStatus) {
		this.billStatus = billStatus;
	}

	public float getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(float productTotal) {
		this.productTotal = productTotal;
	}

	public float getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Date getPurchasedAt() {
		return purchasedAt;
	}

	public void setPurchasedAt(Date purchasedAt) {
		this.purchasedAt = purchasedAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
