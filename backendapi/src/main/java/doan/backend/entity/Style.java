package doan.backend.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Style")
public class Style implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "style_id", nullable = false)
	private Long styleId;
	
	@Column(name = "style_name", length = 100, nullable = false)
	private String styleName;
	
	@OneToMany(mappedBy = "styleFK")
	private Set<DesignIdea> designIdeas;

	public Set<DesignIdea> getDesignIdeas() {
		return designIdeas;
	}

	public void setDesignIdeas(Set<DesignIdea> designIdeas) {
		this.designIdeas = designIdeas;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
