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
import javax.persistence.Table;

@Entity
@Table (name = "design_idea")
public class DesignIdea implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idea_id", nullable = false)
	private Long ideaId;
	
	@Column(name = "idea_name", length = 100, nullable = false)
	private String ideaName;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "category", nullable = false)
	private Long category;
	
	@Column(name = "style", nullable = false)
	private Long style;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "design_idea_item",
			joinColumns = @JoinColumn(name = "idea_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private Set<Product> products;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", nullable = false, updatable = false, insertable = false)
	private Category categoryFK;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "style", nullable = false, updatable = false, insertable = false)
	private Style styleFK;
	
	public Style getStyleFK() {
		return styleFK;
	}

	public void setStyleFK(Style styleFK) {
		this.styleFK = styleFK;
	}

	public Category getCategoryFK() {
		return categoryFK;
	}

	public void setCategoryFK(Category categoryFK) {
		this.categoryFK = categoryFK;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public DesignIdea() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Long ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getStyle() {
		return style;
	}

	public void setStyle(Long style) {
		this.style = style;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
