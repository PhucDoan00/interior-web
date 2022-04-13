package doan.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class CreateDesignIdeaDTO {

	private String ideaName;
	private String description;
	private String image;
	private long categoryId;
	private long styleId;
	private List<Long> productIds;
	
	public CreateDesignIdeaDTO() {
		// TODO Auto-generated constructor stub
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getStyleId() {
		return styleId;
	}

	public void setStyleId(long styleId) {
		this.styleId = styleId;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	
}
