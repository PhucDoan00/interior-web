package doan.flamebackend.demo1.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fb_id;
	@Column(name = "fb_content")
	private String fb_content;
	@Column(name = "created_at")
	private Date created_at;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account customer_id;

	@ManyToOne
	@JoinColumn(name = "fb_title_id")
	private FeedbackTitle fb_title_id;

	public Feedback() {

	}

	public Long getFb_id() {
		return fb_id;
	}

	public void setFb_id(Long fb_id) {
		this.fb_id = fb_id;
	}

	public String getFb_content() {
		return fb_content;
	}

	public void setFb_content(String fb_content) {
		this.fb_content = fb_content;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Account getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Account customer_id) {
		this.customer_id = customer_id;
	}

	public FeedbackTitle getFb_title_id() {
		return fb_title_id;
	}

	public void setFb_title_id(FeedbackTitle fb_title_id) {
		this.fb_title_id = fb_title_id;
	}

	@Override
	public String toString() {
		return "Feedback [fb_id=" + fb_id + ", fb_content=" + fb_content + ", created_at=" + created_at
				+ ", customer_id=" + customer_id + ", fb_title_id=" + fb_title_id + "]";
	}

}
