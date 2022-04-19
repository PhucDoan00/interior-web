package doan.backend.dto;

import java.util.List;

import lombok.Data;

@Data
public class DesignIdeaForStaffDTO {

	private long designIdeaId;
	private String designIdeaName;
	private String designIdeaDescription;
	private long category;
	private long style;
	private String image;
	private List<Long> productIds;
	
	public DesignIdeaForStaffDTO() {
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

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public long getStyle() {
		return style;
	}

	public void setStyle(long style) {
		this.style = style;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

}
