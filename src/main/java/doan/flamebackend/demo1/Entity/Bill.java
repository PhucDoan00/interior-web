package doan.flamebackend.demo1.Entity;

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

@Entity
@Table(name = "Bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bill_id;
	@Column(name = "product_total", nullable = false)
	private float product_total;
	@Column(name = "shipping_fee", nullable = false)
	private float shipping_fee;
	@Column(name = "total_price", nullable = false)
	private float total_price;
	@Column(name = "customer_name", nullable = false)
	private String customer_name;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "purchase_at", nullable = false)
	private Date purchase_at;

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart carts;

	@ManyToOne
	@JoinColumn(name = "cart_status")
	private CartStatus cart_status;
	
	@ManyToOne
	@JoinColumn(name = "stt_id")
	private BillStatus status;

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public float getProduct_total() {
		return product_total;
	}

	public void setProduct_total(float product_total) {
		this.product_total = product_total;
	}

	public float getShipping_fee() {
		return shipping_fee;
	}

	public void setShipping_fee(float shipping_fee) {
		this.shipping_fee = shipping_fee;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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

	public Date getPurchase_at() {
		return purchase_at;
	}

	public void setPurchase_at(Date purchase_at) {
		this.purchase_at = purchase_at;
	}

	public Cart getCarts() {
		return carts;
	}

	public void setCarts(Cart carts) {
		this.carts = carts;
	}

	public CartStatus getCart_status() {
		return cart_status;
	}

	public void setCart_status(CartStatus cart_status) {
		this.cart_status = cart_status;
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", product_total=" + product_total + ", shipping_fee=" + shipping_fee
				+ ", total_price=" + total_price + ", customer_name=" + customer_name + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", purchase_at=" + purchase_at + ", carts=" + carts
				+ ", cart_status=" + cart_status + "]";
	}

}
