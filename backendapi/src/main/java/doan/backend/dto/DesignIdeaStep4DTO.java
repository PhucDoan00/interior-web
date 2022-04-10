package doan.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class DesignIdeaStep4DTO {

	private String categoryName;
	private String styleName;
	private String bigThumbnail;
	private List<DesignIdeaItemsDTO> itemList;
	
	public DesignIdeaStep4DTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public String getBigThumbnail() {
		return bigThumbnail;
	}
	public void setBigThumbnail(String bigThumbnail) {
		this.bigThumbnail = bigThumbnail;
	}
	public List<DesignIdeaItemsDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<DesignIdeaItemsDTO> itemList) {
		this.itemList = itemList;
	}
	
	
}
