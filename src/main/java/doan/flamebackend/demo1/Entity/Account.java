package doan.flamebackend.demo1.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_id;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "user_name", nullable = false)
	private String username;

	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "fb_title_id", cascade = CascadeType.ALL)
	private Collection<Feedback> feedbacks;

	@OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL)
	private Collection<Cart> carts;

	public Account() {

	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Account(Long account_id, String password, String name, String phone, String email, String address,
			String username, Set<Role> roles, Collection<Feedback> feedbacks, Collection<Cart> carts) {
		super();
		this.account_id = account_id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.username = username;
		this.roles = roles;
		this.feedbacks = feedbacks;
		this.carts = carts;
	}

	public Account(String nameAcc, String username, String email, String address, String phone, String password) {
		this.name = nameAcc;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
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
		return "Account [account_id=" + account_id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", username=" + username + ", roles=" + roles
				+ ", feedbacks=" + feedbacks + ", carts=" + carts + "]";
	}

}
