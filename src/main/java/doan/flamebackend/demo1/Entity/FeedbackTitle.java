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
@Table(name = "feedback_title")
public class FeedbackTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fb_title_id;
	@Column(name = "fb_titledes")
	private String fb_titledes;
	@Column(name = "fb_note", nullable = false)
	private String fb_note;

	@OneToMany(mappedBy = "fb_title_id", cascade = CascadeType.ALL)
	private Collection<Feedback> feedbacks;

	public FeedbackTitle() {

	}

	public Long getFb_title_id() {
		return fb_title_id;
	}

	public void setFb_title_id(Long fb_title_id) {
		this.fb_title_id = fb_title_id;
	}

	public String getFb_titledes() {
		return fb_titledes;
	}

	public void setFb_titledes(String fb_titledes) {
		this.fb_titledes = fb_titledes;
	}

	public String getFb_note() {
		return fb_note;
	}

	public void setFb_note(String fb_note) {
		this.fb_note = fb_note;
	}

	public Collection<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Collection<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "FeedbackTitle [fb_title_id=" + fb_title_id + ", fb_titledes=" + fb_titledes + ", fb_note=" + fb_note
				+ ", feedbacks=" + feedbacks + "]";
	}

}
