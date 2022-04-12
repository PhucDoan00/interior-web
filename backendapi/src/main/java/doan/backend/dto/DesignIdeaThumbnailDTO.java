package doan.backend.dto;

import lombok.Data;

@Data
public class DesignIdeaThumbnailDTO {

	private String styleName;
	private String image;
	private String imageBig;
	private String description;
	
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

	public String getImageBig() {
		return imageBig;
	}

	public void setImageBig(String imageBig) {
		this.imageBig = imageBig;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
