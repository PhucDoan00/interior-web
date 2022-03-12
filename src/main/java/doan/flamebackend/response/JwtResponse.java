package doan.flamebackend.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long accountId;
	private String email;
	private String fullName;
	private String phone;
	private List<String> roles;

	public JwtResponse() {

	}

	public JwtResponse(String token, Long accountId, String email, String fullName, String phone, List<String> roles) {
		super();
		this.token = token;
		this.accountId = accountId;
		this.email = email;
		this.fullName = fullName;
		this.phone = phone;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
