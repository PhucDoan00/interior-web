package doan.flamebackend.demo1.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Role")
public class Role {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	@JsonBackReference
	@ManyToMany(mappedBy = "roles")
	private Set<Account> accounts;

	public Role() {

	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public ERole getRole_name() {
		return name;
	}

	public void setRole_name(ERole name) {
		this.name = name;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
