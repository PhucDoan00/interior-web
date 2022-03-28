package doan.flamebackend.demo1.Entity;

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
@Table(name = "Style")
public class Style {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long style_id;
	@Column(name = "style_name")
	private String style_name;

	@OneToMany(mappedBy = "style", cascade = CascadeType.ALL)
	private Collection<DesignIdea> ideas;

	public Style() {

	}

	public Long getStyle_id() {
		return style_id;
	}

	public void setStyle_id(Long style_id) {
		this.style_id = style_id;
	}

	public String getStyle_name() {
		return style_name;
	}

	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}

	public Collection<DesignIdea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Collection<DesignIdea> ideas) {
		this.ideas = ideas;
	}

	@Override
	public String toString() {
		return "Style [style_id=" + style_id + ", style_name=" + style_name + ", ideas=" + ideas + "]";
	}

}
