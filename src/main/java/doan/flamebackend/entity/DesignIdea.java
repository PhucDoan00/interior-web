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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "design-idea")
public class DesignIdea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idea_id", nullable = false)
	private long ideaId;
	@Column(name = "idea_name", nullable = false)
	private String ideaName;
	@ManyToOne
	@JoinColumn(name = "style_id", nullable = false)
	private Style styleId;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category categoryId;
	@OneToMany
	@JoinColumn(name = "style", nullable = false)
	private int style;
	@Column(name = "image", nullable = false)
	private String image;
	@Column(name = "description", nullable = false)
	private String description;

	@OneToMany(mappedBy = "design-idea", cascade = CascadeType.ALL)
	private Collection<DesignIdea> ideaIds;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "design-idea", joinColumns = @JoinColumn(name = "idea_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Collection<Product> products;

	public DesignIdea() {

	}

	public DesignIdea(long ideaId, String ideaName, Style styleId, Category categoryId, int style, String image,
			String description, Collection<DesignIdea> ideaIds, Collection<Product> products) {
		super();
		this.ideaId = ideaId;
		this.ideaName = ideaName;
		this.styleId = styleId;
		this.categoryId = categoryId;
		this.style = style;
		this.image = image;
		this.description = description;
		this.ideaIds = ideaIds;
		this.products = products;
	}

	public long getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(long ideaId) {
		this.ideaId = ideaId;
	}

	public String getIdeaName() {
		return ideaName;
	}

	public void setIdeaName(String ideaName) {
		this.ideaName = ideaName;
	}

	public Style getStyleId() {
		return styleId;
	}

	public void setStyleId(Style styleId) {
		this.styleId = styleId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
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

	public Collection<DesignIdea> getIdeaIds() {
		return ideaIds;
	}

	public void setIdeaIds(Collection<DesignIdea> ideaIds) {
		this.ideaIds = ideaIds;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "DesignIdea [ideaId=" + ideaId + ", ideaName=" + ideaName + ", styleId=" + styleId + ", categoryId="
				+ categoryId + ", style=" + style + ", image=" + image + ", description=" + description + ", ideaIds="
				+ ideaIds + ", products=" + products + "]";
	}

}
