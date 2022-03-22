package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "style")
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "style_id", nullable = false)
	private long styleId;
	@Column(name = "style_name", nullable = false)
	private String styleName;

	@OneToMany(mappedBy = "style_id", cascade = CascadeType.ALL)
	private Collection<DesignIdea> styleIds;

	public Style() {

	}

	public Style(long styleId, String styleName, Collection<DesignIdea> styleIds) {
		super();
		this.styleId = styleId;
		this.styleName = styleName;
		this.styleIds = styleIds;
	}

	public long getStyleId() {
		return styleId;
	}

	public void setStyleId(long styleId) {
		this.styleId = styleId;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Collection<DesignIdea> getStyleIds() {
		return styleIds;
	}

	public void setStyleIds(Collection<DesignIdea> styleIds) {
		this.styleIds = styleIds;
	}

	@Override
	public String toString() {
		return "Style [styleId=" + styleId + ", styleName=" + styleName + ", styleIds=" + styleIds + "]";
	}

}
