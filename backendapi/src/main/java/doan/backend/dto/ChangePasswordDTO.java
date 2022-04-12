package doan.backend.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {

	private String currentPassword;
	private String newPassword;
	private String retypePassword;
	
	public ChangePasswordDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
}
