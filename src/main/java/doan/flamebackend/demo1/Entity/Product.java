package doan.flamebackend.demo1.Entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	@Column(name = "product_name")
	private String product_name;
	@Column(name = "price")
	private float price;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "image")
	private String image;
	@Column(name = "description")
	private String description;
	@Column(name = "bought_count")
	private Integer bought_count;
	@Column(name = "material")
	private String material;
	@Column(name = "dimension")
	private String dimension;

	@JsonBackReference
	@ManyToMany(mappedBy = "products")
	private Collection<Cart> carts;

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Collection<Category> categories;

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_color", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
	private Collection<Color> colors;

	@JsonBackReference
	@ManyToMany(mappedBy = "products")
	private Collection<DesignIdea> ideas;

	public Product() {

	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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

	public Integer getBought_count() {
		return bought_count;
	}

	public void setBought_count(Integer bought_count) {
		this.bought_count = bought_count;
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

	public Collection<Color> getColors() {
		return colors;
	}

	public void setColors(Collection<Color> colors) {
		this.colors = colors;
	}

	public Collection<DesignIdea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Collection<DesignIdea> ideas) {
		this.ideas = ideas;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", image=" + image + ", description=" + description + ", bought_count="
				+ bought_count + ", material=" + material + ", dimension=" + dimension + ", carts=" + carts
				+ ", colors=" + colors + ", ideas=" + ideas + "]";
	}

}
