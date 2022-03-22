package doan.flamebackend.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product-color")
public class ProductColor {

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private long productId;
	@OneToOne
	@JoinColumn(name = "color_id", nullable = false)
	private Color colorId;

	public ProductColor() {

	}

	public ProductColor(long productId, Color colorId) {
		super();
		this.productId = productId;
		this.colorId = colorId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Color getColorId() {
		return colorId;
	}

	public void setColorId(Color colorId) {
		this.colorId = colorId;
	}

	@Override
	public String toString() {
		return "ProductColor [productId=" + productId + ", colorId=" + colorId + "]";
	}

}
