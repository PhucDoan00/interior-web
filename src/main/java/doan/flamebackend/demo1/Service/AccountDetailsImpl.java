package doan.flamebackend.demo1.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import doan.flamebackend.demo1.Entity.Account;

public class AccountDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nameAcc;

	private String username;

	private String email;

	private String phone;

	@JsonIgnore
	private String password;


	private Collection<? extends GrantedAuthority> authorities;

	public AccountDetailsImpl(Long id, String nameAcc, String username, String email, String phone, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.nameAcc = nameAcc;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.authorities = authorities;;
	}

	public static AccountDetailsImpl build(Account account) {
		List<GrantedAuthority> authorities = account.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole_name().name())).collect(Collectors.toList());

		return new AccountDetailsImpl(account.getAccount_id(), account.getName(), account.getUsername(), account.getEmail(),
				account.getPhone(), account.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getNameAcc() {
		return nameAcc;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AccountDetailsImpl user = (AccountDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
