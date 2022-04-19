package doan.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class DesignIdeaStep3DTO {

	private String categoryName;
	private String bigImg;
	private List<DesignIdeaThumbnailDTO> thumbnailList;
	
	public DesignIdeaStep3DTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DesignIdeaThumbnailDTO> getThumbnailList() {
		return thumbnailList;
	}

	public void setThumbnailList(List<DesignIdeaThumbnailDTO> thumbnailList) {
		this.thumbnailList = thumbnailList;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	
}
