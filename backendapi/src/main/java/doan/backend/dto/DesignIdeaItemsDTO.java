package doan.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class DesignIdeaItemsDTO {

	private long designIdeaId;
	private String designIdeaName;
	private String designIdeaDescription;
	private String categoryName;
	private String styleName;
	private String image;
	private List<ProductInformationDTO> itemList;
	
	public DesignIdeaItemsDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getDesignIdeaId() {
		return designIdeaId;
	}

	public void setDesignIdeaId(long designIdeaId) {
		this.designIdeaId = designIdeaId;
	}

	public String getDesignIdeaName() {
		return designIdeaName;
	}

	public void setDesignIdeaName(String designIdeaName) {
		this.designIdeaName = designIdeaName;
	}

	public String getDesignIdeaDescription() {
		return designIdeaDescription;
	}

	public void setDesignIdeaDescription(String designIdeaDescription) {
		this.designIdeaDescription = designIdeaDescription;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ProductInformationDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ProductInformationDTO> itemList) {
		this.itemList = itemList;
	}
	
	
}
