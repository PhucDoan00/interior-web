package doan.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.AccountInformationDTO;
import doan.backend.dto.ChangePasswordDTO;
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
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//ADMIN + STAFF + CUSTOMER - View Personal Information 
	@GetMapping("")
	public ResponseEntity<?> profile(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account acc = accountRepository.findByEmail(email);
    	
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
	
	//ADMIN + STAFF + CUSTOMER - Edit Personal Information (Not Change Password)
	//REQUEST BODY DOES NOT NEED PASSWORD AND ROLE
	@PutMapping("")
	public ResponseEntity<?> editProfile(HttpServletRequest request, @RequestBody AccountInformationDTO info) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account acc = accountRepository.findByEmail(email);
    	
    	if (accountRepository.existsByEmail(email)) return new ResponseEntity<> ("Email is already taken!", HttpStatus.OK);
		accountRepository.updateAccountInfo(info.getName(), info.getPhone(), info.getEmail(), info.getAddress(), acc.getAccountId());
		return new ResponseEntity<> ("Information Updated!", HttpStatus.OK);
	}
	
	//ADMIN + STAFF + CUSTOMER - Change Password
	@PutMapping("/changepassword")
	public ResponseEntity<?> changePassword(HttpServletRequest request, @RequestBody ChangePasswordDTO password) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account acc = accountRepository.findByEmail(email);
    	
		if (!passwordEncoder.matches(password.getCurrentPassword(), acc.getPassword())) return new ResponseEntity<> ("Current password is wrong", HttpStatus.BAD_REQUEST);
		if (password.getCurrentPassword().equals(password.getNewPassword())) return new ResponseEntity<> ("New password cannot be the same as current password", HttpStatus.BAD_REQUEST);
		if (!password.getRetypePassword().equals(password.getNewPassword())) return new ResponseEntity<> ("Re-type password is not the same as new password", HttpStatus.BAD_REQUEST);
		
		accountRepository.changePassword(passwordEncoder.encode(password.getNewPassword()), acc.getAccountId());
		return new ResponseEntity<> ("Password is Changed!", HttpStatus.OK);
	}
}
