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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "design_idea")
public class DesignIdea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idea_id;
	@Column(name = "idea_name")
	private String idea_name;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;

	@ManyToOne
	@JoinColumn(name = "style_id")
	private Style style;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "design_idea_item", joinColumns = @JoinColumn(name = "idea_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Collection<Product> products;

	public DesignIdea() {

	}

	public Long getIdea_id() {
		return idea_id;
	}

	public void setIdea_id(Long idea_id) {
		this.idea_id = idea_id;
	}

	public String getIdea_name() {
		return idea_name;
	}

	public void setIdea_name(String idea_name) {
		this.idea_name = idea_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "DesignIdea [idea_id=" + idea_id + ", idea_name=" + idea_name + ", description=" + description
				+ ", image=" + image + ", style=" + style + ", category=" + category + ", products=" + products + "]";
	}

}
