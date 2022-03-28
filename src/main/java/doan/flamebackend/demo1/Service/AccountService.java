package doan.flamebackend.demo1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.demo1.Entity.Account;

@Service
public interface AccountService {
	Account getAccountById(Long account_id);

	Account updateAccountById(Account account, Long account_id);

	List<Account> getAllAccounts();

	void deleteAccountById(Long account_id);
}
