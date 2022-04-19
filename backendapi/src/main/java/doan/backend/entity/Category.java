package doan.backend.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", nullable = false)
	private Long categoryId;
	
	@Column(name = "category_name", length = 100, nullable = false)
	private String categoryName;
	
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
	@OneToMany(mappedBy = "categoryFK")
	private Set<DesignIdea> designIdeas;
	
	public Set<DesignIdea> getDesignIdeas() {
		return designIdeas;
	}

	public void setDesignIdeas(Set<DesignIdea> designIdeas) {
		this.designIdeas = designIdeas;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
