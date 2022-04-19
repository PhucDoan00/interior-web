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
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "color_id", nullable = false)
	private Long colorId;
	
	@Column(name = "color_name", length = 100, nullable = false)
	private String colorName;
	
	@ManyToMany(mappedBy = "colors")
	private Set<Product> products = new HashSet<>();
	
	public Color() {
		// TODO Auto-generated constructor stub
	}

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
