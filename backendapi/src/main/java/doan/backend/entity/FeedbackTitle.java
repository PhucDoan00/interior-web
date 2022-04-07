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
@Table (name = "feedback_title")
public class FeedbackTitle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fb_title_id", nullable = false)
	private Long fbTitleId;
	
	@Column(name = "fb_title_des", nullable = false)
	private String fbTitleDes;
	
	@Column(name = "fb_note", nullable = true)
	private String fbNote;
	
	@OneToMany(mappedBy = "feedbackTitle")
	private Set<Feedback> feedbacks;

	public Long getFbTitleId() {
		return fbTitleId;
	}

	public void setFbTitleId(Long fbTitleId) {
		this.fbTitleId = fbTitleId;
	}

	public String getFbTitleDes() {
		return fbTitleDes;
	}

	public void setFbTitleDes(String fbTitleDes) {
		this.fbTitleDes = fbTitleDes;
	}

	public String getFbNote() {
		return fbNote;
	}

	public void setFbNote(String fbNote) {
		this.fbNote = fbNote;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
