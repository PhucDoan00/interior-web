package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@ManyToOne
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", nullable = false)
	private long categoryId;
	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@ManyToMany(mappedBy = "categories")
	private Collection<Product> products;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Collection<DesignIdea> designIdeas;

	public Category() {

	}

	public Category(long categoryId, String categoryName, Collection<Product> products,
			Collection<DesignIdea> designIdeas) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.products = products;
		this.designIdeas = designIdeas;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public Collection<DesignIdea> getDesignIdeas() {
		return designIdeas;
	}

	public void setDesignIdeas(Collection<DesignIdea> designIdeas) {
		this.designIdeas = designIdeas;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products
				+ ", designIdeas=" + designIdeas + "]";
	}

}
