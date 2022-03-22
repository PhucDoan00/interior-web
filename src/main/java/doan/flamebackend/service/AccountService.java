package doan.flamebackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Account;

@Service
public interface AccountService {
	Account getAccountById(Long accountId);

	Account updateAccountById(Account account, Long accountId);

	List<Account> getAllAccounts();

	void deleteAccountById(Long accountId);

	Account changePassword(Long accountId);

}
