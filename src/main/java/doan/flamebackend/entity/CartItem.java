package doan.flamebackend.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "cart-item")
public class CartItem {

	@Id
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private long cartId;
	@Id
	@JoinColumn(name = "product_id", nullable = false)
	private long productId;
	@Column(name = "quantity", nullable = false)
	@Min(0)
	private int quantity;
	@Column(name = "price", nullable = false)
	@Min(1)
	private float price;
	@Column(name = "added_at", nullable = false)
	private Date addedAt;

	@OneToMany(mappedBy = "cart-item", cascade = CascadeType.ALL)
	private Collection<Product> productIds;

	public CartItem() {

	}

	public CartItem(long cartId, long productId, @Min(0) int quantity, @Min(1) float price, Date addedAt,
			Collection<Product> productIds) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.addedAt = addedAt;
		this.productIds = productIds;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}

	public Collection<Product> getProductIds() {
		return productIds;
	}

	public void setProductIds(Collection<Product> productIds) {
		this.productIds = productIds;
	}

	@Override
	public String toString() {
		return "CartItem [cartId=" + cartId + ", productId=" + productId + ", quantity=" + quantity + ", price="
				+ price + ", addedAt=" + addedAt + ", productIds=" + productIds + "]";
	}

}
