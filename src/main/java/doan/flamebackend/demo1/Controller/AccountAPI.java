package doan.flamebackend.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.demo1.Entity.Account;
import doan.flamebackend.demo1.Service.AccountService;

@RestController
@RequestMapping(path = "api/accounts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountAPI {

	private AccountService accountService;

	@Autowired
	public AccountAPI(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/accounts")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllAccounts(@RequestParam(required = false) Long account_id) {
		if (account_id == null) {
			return ResponseEntity.ok(accountService.getAllAccounts());
		}
		return ResponseEntity.ok(accountService.getAllAccounts());
	}

	@GetMapping("/{account_id}")
	@PreAuthorize("hasRole('CUSTOMER') and hasRole('STAFF')")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable Long account_id) {
		return ResponseEntity.ok(accountService.getAccountById(account_id));
	}

	@PutMapping("/{account_id}/update")
	@PreAuthorize("hasRole('CUSTOMER')")
	public Account updateAccountById(@RequestBody Account account, @PathVariable Long account_id) {
		return accountService.updateAccountById(account, account_id);
	}

	@DeleteMapping("/{account_id}/delete")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> deleteAccountById(@PathVariable Long account_id) {
		accountService.deleteAccountById(account_id);
		return ResponseEntity.ok().build();
	}

}
