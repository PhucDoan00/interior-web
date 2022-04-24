package doan.backend.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AccountInformationDTO {

	private long accountId;
	private String name;
	private String oldEmail;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Collection< ? extends GrantedAuthority> roles;
    
    public AccountInformationDTO() {
		// TODO Auto-generated constructor stub
	}
    
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}
	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	public String getOldEmail() {
		return oldEmail;
	}

	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}
	
}
