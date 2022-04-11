package doan.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.AccountInformationDTO;
import doan.backend.entity.Account;
import doan.backend.repository.AccountRepository;
import doan.backend.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api/v1/profile")
public class AccountProfileController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private CustomUserDetailsService customUserDetails;
	
	@GetMapping("")
	public ResponseEntity<AccountInformationDTO> profile(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		Account acc = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
		
		AccountInformationDTO info = new AccountInformationDTO();
        info.setAccountId(acc.getAccountId());
        info.setEmail(acc.getEmail());
        info.setAddress(acc.getAddress());
        info.setName(acc.getName());
        info.setPassword(acc.getPassword());
        info.setPhone(acc.getPhone());
        info.setRoles(customUserDetails.loadUserByUsername(acc.getEmail()).getAuthorities());
		return new ResponseEntity<AccountInformationDTO> (info, HttpStatus.OK);
	}
}
