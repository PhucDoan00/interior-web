package doan.flamebackend.demo1.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Color")
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long color_id;
	@Column(name = "color_name")
	private String color_name;

	@JsonBackReference
	@ManyToMany(mappedBy = "colors")
	private Collection<Product> products;

	public Color() {

	}

	public Long getColor_id() {
		return color_id;
	}

	public void setColor_id(Long color_id) {
		this.color_id = color_id;
	}

	public String getColor_name() {
		return color_name;
	}

	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Color [color_id=" + color_id + ", color_name=" + color_name + ", products=" + products + "]";
	}

}
