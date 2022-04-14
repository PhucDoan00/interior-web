package doan.backend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.AccountInformationDTO;
import doan.backend.entity.Account;
import doan.backend.repository.AccountRepository;
import doan.backend.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private CustomUserDetailsService customUserDetails;
	
	@GetMapping("")
	public ResponseEntity<?> getAllAccounts(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
    	int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account acc = accountRepository.findByEmail(email);

		List<AccountInformationDTO> finalList = new ArrayList<AccountInformationDTO>();
		List<Account> allAccounts = accountRepository.findAll();
		
		for (Account account : allAccounts) {
			if (account.getAccountId() != 1) {
				AccountInformationDTO info = new AccountInformationDTO();
		        info.setAccountId(account.getAccountId());
		        info.setEmail(account.getEmail());
		        info.setAddress(account.getAddress());
		        info.setName(account.getName());
		        info.setPassword(account.getPassword());
		        info.setPhone(account.getPhone());
		        info.setRoles(customUserDetails.loadUserByUsername(account.getEmail()).getAuthorities());
		        finalList.add(info);
			}
		}
		return new ResponseEntity<List<AccountInformationDTO>> (finalList, HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> getAllAccountsSearch(@RequestBody String searchString, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
    	int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	Account acc = accountRepository.findByEmail(email);
    	
		List<AccountInformationDTO> finalList = new ArrayList<AccountInformationDTO>();
		String finalString = "%" + searchString +"%";
		List<Account> allAccounts = accountRepository.searchAccountsNotAdmin(finalString);
		
		for (Account account : allAccounts) {
			if (account.getAccountId() != 1) {
				AccountInformationDTO info = new AccountInformationDTO();
		        info.setAccountId(account.getAccountId());
		        info.setEmail(account.getEmail());
		        info.setAddress(account.getAddress());
		        info.setName(account.getName());
		        info.setPassword(account.getPassword());
		        info.setPhone(account.getPhone());
		        info.setRoles(customUserDetails.loadUserByUsername(account.getEmail()).getAuthorities());
		        finalList.add(info);
			}
		}
		return new ResponseEntity<List<AccountInformationDTO>> (finalList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneAccount(HttpServletRequest request, @PathVariable(value = "id") Long accountId) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	
    	int count2 = accountRepository.countExistID(accountId);
    	if (count2 == 0) return new ResponseEntity<>("User not found with id: " + accountId, HttpStatus.BAD_REQUEST);
		
		Account account = accountRepository.getById(accountId);
		if (account.getAccountId() == 1) return new ResponseEntity<>("You cannot get an admin account's information here!", HttpStatus.OK);
		
		AccountInformationDTO info = new AccountInformationDTO();
		info.setAccountId(account.getAccountId());
        info.setEmail(account.getEmail());
        info.setAddress(account.getAddress());
        info.setName(account.getName());
        info.setPassword(account.getPassword());
        info.setPhone(account.getPhone());
        info.setRoles(customUserDetails.loadUserByUsername(account.getEmail()).getAuthorities());
		return new ResponseEntity<AccountInformationDTO> (info, HttpStatus.OK);
	}
	
	//REQUEST BODY ONLY NEED NAME, PHONE, EMAIL AND ADDRESS
	@PostMapping("/{id}")
	public ResponseEntity<?> updateNotAdminAccount(@RequestBody AccountInformationDTO info, @PathVariable(value = "id") Long accountId, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	
    	int count2 = accountRepository.countExistID(accountId);
    	if (count2 == 0) return new ResponseEntity<>("User not found with id: " + accountId, HttpStatus.BAD_REQUEST);
		
		Account account = accountRepository.getById(accountId);
		if (accountRepository.existsByEmail(account.getEmail())) return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
		
		if (account.getAccountId() == 1) return new ResponseEntity<>("You cannot update an admin account's information here!", HttpStatus.OK);
		
		accountRepository.updateAccountInfo(info.getName(), info.getPhone(), info.getEmail(), info.getAddress(), accountId);
		return new ResponseEntity<> ("Updated Successful!", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteNotAdminAccount(@PathVariable(value = "id") Long accountId, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.BAD_REQUEST);
    	
    	int count2 = accountRepository.countExistID(accountId);
    	if (count2 == 0) return new ResponseEntity<>("User not found with id: " + accountId, HttpStatus.BAD_REQUEST);
		
		Account account = accountRepository.getById(accountId);
		if (account.getAccountId() == 1) return new ResponseEntity<>("You cannot delete an admin account!", HttpStatus.OK);
		
		accountRepository.deleteAccount(accountId);
		return new ResponseEntity<> ("Deleted Successful!", HttpStatus.OK);
	}
}
