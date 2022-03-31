package doan.backend.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import doan.backend.entity.Account;
import doan.backend.entity.Role;
import doan.backend.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private AccountRepository accountRepository;
	
	
	public CustomUserDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account acc = accountRepository.findByEmail(email)
	               .orElseThrow(() ->
	                       new UsernameNotFoundException("User not found with email:" + email));
	        return new org.springframework.security.core.userdetails.User(acc.getEmail(),
	                acc.getPassword(), mapRolesToAuthorities(acc.getRoles()));
	}
	
	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
