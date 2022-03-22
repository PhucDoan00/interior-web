package doan.flamebackend.entity;

import java.util.Collection;

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
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private long productId;
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "price", nullable = false)
	@Min(1)
	private float price;
	@Column(name = "quantity", nullable = false)
	@Min(0)
	private int quantity;
	@Column(name = "image", nullable = false)
	private String image;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "bought_count", nullable = false)
	@Min(0)
	private int boughtCount;
	@Column(name = "material")
	private String material;
	@Column(name = "dimension", nullable = false)
	private String dimension;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_item", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
	private Collection<Cart> carts;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Collection<Category> categories;
	@ManyToMany(mappedBy = "products")
	private Collection<DesignIdea> ideaIds;

	public Product() {

	}

	public Product(long productId, String productName, @Min(1) float price, @Min(0) int quantity, String image,
			String description, @Min(0) int boughtCount, String material, String dimension, Collection<Cart> carts,
			Collection<Category> categories, Collection<DesignIdea> ideaIds) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.boughtCount = boughtCount;
		this.material = material;
		this.dimension = dimension;
		this.carts = carts;
		this.categories = categories;
		this.ideaIds = ideaIds;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBoughtCount() {
		return boughtCount;
	}

	public void setBoughtCount(int boughtCount) {
		this.boughtCount = boughtCount;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	public Collection<Category> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	public Collection<DesignIdea> getIdeaIds() {
		return ideaIds;
	}

	public void setIdeaIds(Collection<DesignIdea> ideaIds) {
		this.ideaIds = ideaIds;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", image=" + image + ", description=" + description + ", boughtCount=" + boughtCount
				+ ", material=" + material + ", dimension=" + dimension + ", carts=" + carts + ", categories="
				+ categories + ", ideaIds=" + ideaIds + "]";
	}

}
