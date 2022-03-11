package doan.flamebackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fb_id", nullable = false)
	private long fbId;
	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false)
	private long customerId;
	@ManyToOne
	@JoinColumn(name = "fb_title_id", nullable = false)
	private Feedback fbTitle;
	@Column(name = "fb-content", nullable = false)
	private int fbContent;
	@Column(name = "created-at", nullable = true)
	private int createdAt;

	public Feedback() {

	}

	public Feedback(long fbId, long customerId, Feedback fbTitle, int fbContent, int createdAt) {
		super();
		this.fbId = fbId;
		this.customerId = customerId;
		this.fbTitle = fbTitle;
		this.fbContent = fbContent;
		this.createdAt = createdAt;
	}

	public long getFbId() {
		return fbId;
	}

	public void setFbId(long fbId) {
		this.fbId = fbId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Feedback getFbTitle() {
		return fbTitle;
	}

	public void setFbTitle(Feedback fbTitle) {
		this.fbTitle = fbTitle;
	}

	public int getFbContent() {
		return fbContent;
	}

	public void setFbContent(int fbContent) {
		this.fbContent = fbContent;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Feedback [fbId=" + fbId + ", customerId=" + customerId + ", fbTitle=" + fbTitle + ", fbContent="
				+ fbContent + ", createdAt=" + createdAt + "]";
	}

}
