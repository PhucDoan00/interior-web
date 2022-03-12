package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private long accountId;
	@Column(name = "password", nullable = false)
	private String passWord;
	@Column(name = "full_name", nullable = false)
	private String fullName;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "address", nullable = false)
	private String address;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Collection<Feedback> feedbacks;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Collection<Cart> carts;

	public Account() {

	}

	public Account(long accountId, String passWord, String fullName, String phone, String email, String address,
			Collection<Role> roles, Collection<Feedback> feedbacks, Collection<Cart> carts) {
		super();
		this.accountId = accountId;
		this.passWord = passWord;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.roles = roles;
		this.feedbacks = feedbacks;
		this.carts = carts;
	}

	public Account(Object email2, String address2, String fullName2, String phone2, String encode) {
		// TODO Auto-generated constructor stub
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Collection<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Collection<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", passWord=" + passWord + ", fullName=" + fullName + ", phone="
				+ phone + ", email=" + email + ", address=" + address + ", roles=" + roles + ", feedbacks=" + feedbacks
				+ ", carts=" + carts + "]";
	}

}
