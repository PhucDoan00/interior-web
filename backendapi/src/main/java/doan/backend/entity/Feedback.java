package doan.backend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Feedback")
public class Feedback implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fb_id", nullable = false)
	private Long fbId;
	
	@Column(name = "customer_id", nullable = false)
	private Long customerId;
	
	@Column(name = "fb_title", nullable = false)
	private Long fbTitle;
	
	@Column(name = "fb_content", nullable = false)
	private String fbContent;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false, updatable = false, insertable = false)
	private Account account;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fb_title", nullable = false, updatable = false, insertable = false)
	private FeedbackTitle feedbackTitle;
	
	public FeedbackTitle getFeedbackTitle() {
		return feedbackTitle;
	}

	public void setFeedbackTitle(FeedbackTitle feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getFbTitle() {
		return fbTitle;
	}

	public void setFbTitle(Long fbTitle) {
		this.fbTitle = fbTitle;
	}

	public String getFbContent() {
		return fbContent;
	}

	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
