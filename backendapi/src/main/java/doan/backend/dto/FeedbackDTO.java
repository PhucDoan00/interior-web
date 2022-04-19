package doan.backend.dto;

import lombok.Data;

@Data
public class FeedbackDTO {

	private long fbId;
	private long customerId;
	private String customerName;
	private String fbContent;
	private String phone;
	private String address;
	private String email;
	private String createdDate;
	
	public FeedbackDTO() {
		// TODO Auto-generated constructor stub
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFbContent() {
		return fbContent;
	}

	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
