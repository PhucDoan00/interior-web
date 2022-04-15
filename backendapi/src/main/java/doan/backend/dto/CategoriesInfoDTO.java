package doan.backend.dto;

import lombok.Data;

@Data
public class CategoriesInfoDTO {
	private long categoryId;
	private String categoryName;
	private String image;
	
	public CategoriesInfoDTO() {
		// TODO Auto-generated constructor stub
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
