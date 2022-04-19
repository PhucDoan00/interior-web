package doan.backend.dto;

import java.util.Set;

import lombok.Data;

@Data
public class CreateProductDTO {

	private String productName;
	private float price;
	private int quantity;
	private String image;
	private String description;
	private String material;
	private String dimension;
	private Set<Long> colorIds;
	private Set<Long> categoryIds;
	
	public CreateProductDTO() {
		// TODO Auto-generated constructor stub
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

	public Set<Long> getColorIds() {
		return colorIds;
	}

	public void setColorIds(Set<Long> colorIds) {
		this.colorIds = colorIds;
	}

	public Set<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Set<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

}
