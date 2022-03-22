package doan.flamebackend.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	public static final String ROLE_USER = null;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private long roleId;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole eRolename;

	@ManyToMany(mappedBy = "roles")
	private Collection<Account> accounts;

	public Role() {

	}

	public Role(long roleId, ERole eRolename, Collection<Account> accounts) {
		super();
		this.roleId = roleId;
		this.eRolename = eRolename;
		this.accounts = accounts;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public ERole geteRolename() {
		return eRolename;
	}

	public void seteRolename(ERole eRolename) {
		this.eRolename = eRolename;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", eRolename=" + eRolename + ", accounts=" + accounts + "]";
	}

}
