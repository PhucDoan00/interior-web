package doan.flamebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.entity.Account;
import doan.flamebackend.service.AccountService;

@RestController
@RequestMapping(path = "/api/accounts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountAPI {

	@Autowired
	private AccountService accountService;

	@GetMapping()
	public ResponseEntity<?> getAllAccounts(@RequestParam(required = false) Long accountId) {
		if (accountId == null) {
			return ResponseEntity.ok(accountService.getAllAccounts());
		}
		return ResponseEntity.ok(accountService.getAllAccounts());
	}

	@GetMapping("/{AccountId}/")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable Long accountId) {
		return ResponseEntity.ok(accountService.getAccountById(accountId));
	}

	@PutMapping("/{AccountId}/update")
	public Account updateAccountById(@RequestBody Account account, @PathVariable Long accountId) {
		return accountService.updateAccountById(account, accountId);
	}

	@DeleteMapping("/{AccountId}/delete")
	public ResponseEntity<?> deleteAccountById(@PathVariable Long accountId) {
		accountService.deleteAccountById(accountId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("{AccountId}/changePassword")
	public Account ChangePassword(@PathVariable Long accountId) {
		return accountService.changePassword(accountId);
	}
}
