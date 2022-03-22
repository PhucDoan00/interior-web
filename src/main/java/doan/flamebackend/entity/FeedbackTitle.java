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
@Table(name = "feedback-title")
public class FeedbackTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fb_title_id", nullable = false)
	private long fbTitleId;
	@Column(name = "fb_title_des", nullable = false)
	private String fbTitleDes;
	@Column(name = "fb_note", nullable = false)
	private String fbNote;

	@OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL)
	private Collection<FeedbackTitle> feedbacks;

	public FeedbackTitle() {

	}

	public FeedbackTitle(long fbTitleId, String fbTitleDes, String fbNote, Collection<FeedbackTitle> feedbacks) {
		super();
		this.fbTitleId = fbTitleId;
		this.fbTitleDes = fbTitleDes;
		this.fbNote = fbNote;
		this.feedbacks = feedbacks;
	}

	public long getFbTitleId() {
		return fbTitleId;
	}

	public void setFbTitleId(long fbTitleId) {
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

	public Collection<FeedbackTitle> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Collection<FeedbackTitle> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "FeedbackTitle [fbTitleId=" + fbTitleId + ", fbTitleDes=" + fbTitleDes + ", fbNote=" + fbNote
				+ ", feedbacks=" + feedbacks + "]";
	}

}
