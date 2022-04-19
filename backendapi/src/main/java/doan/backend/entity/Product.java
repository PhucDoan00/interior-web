package doan.backend.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	@Column(name = "product_name", length = 150, nullable = false)
	private String productName;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "bought_count", nullable = false)
	private Integer boughtCount;
	
	@Column(name = "material", length = 100, nullable = true)
	private String material;
	
	@Column(name = "dimension", length = 100, nullable = false)
	private String dimension;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "product_category",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> categories = new HashSet<>();
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "product_color",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "color_id")
	)
	private Set<Color> colors = new HashSet<>();
	
	@ManyToMany(mappedBy = "products")
	private Set<Cart> carts = new HashSet<>();
	
	@ManyToMany(mappedBy = "products")
	private Set<DesignIdea> designIdeas;
	
	public Set<DesignIdea> getDesignIdeas() {
		return designIdeas;
	}

	public void setDesignIdeas(Set<DesignIdea> designIdeas) {
		this.designIdeas = designIdeas;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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

	public Integer getBoughtCount() {
		return boughtCount;
	}

	public void setBoughtCount(Integer boughtCount) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	
}
