package doan.backend.dto;

import lombok.Data;

@Data
public class DesignIdeaThumbnailDTO {

	private String styleName;
	private String image;
	
	public DesignIdeaThumbnailDTO() {
		// TODO Auto-generated constructor stub
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
	
	
}
