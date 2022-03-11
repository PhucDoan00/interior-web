package doan.flamebackend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id", nullable = false)
	private long billId;
	@OneToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cartId;
	@ManyToOne
	@JoinColumn(name = "bill_status", nullable = false)
	private int billStatus;
	@Column(name = "product_total", nullable = false)
	@Min(1)
	private int productTotal;
	@Column(name = "shipping_fee", nullable = false)
	@Min(0)
	private int shippingFee;
	@Column(name = "total_price", nullable = false)
	@Min(1)
	private int totalPrice;
	@Column(name = "customer_name", nullable = false)
	private String customerName;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "purchase_at", nullable = false)
	private Date purchaseAt;

	public Bill() {

	}

	public Bill(long billId, Cart cartId, int billStatus, @Min(1) int productTotal, @Min(0) int shippingFee,
			@Min(1) int totalPrice, String customerName, String phone, String email, String address, Date purchaseAt) {
		super();
		this.billId = billId;
		this.cartId = cartId;
		this.billStatus = billStatus;
		this.productTotal = productTotal;
		this.shippingFee = shippingFee;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.purchaseAt = purchaseAt;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public int getProductTotal() {
		return productTotal;
	}

	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}

	public int getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(int shippingFee) {
		this.shippingFee = shippingFee;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
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

	public Date getPurchaseAt() {
		return purchaseAt;
	}

	public void setPurchaseAt(Date purchaseAt) {
		this.purchaseAt = purchaseAt;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", cartId=" + cartId + ", billStatus=" + billStatus + ", productTotal="
				+ productTotal + ", shippingFee=" + shippingFee + ", totalPrice=" + totalPrice + ", customerName="
				+ customerName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", purchaseAt="
				+ purchaseAt + "]";
	}

}
