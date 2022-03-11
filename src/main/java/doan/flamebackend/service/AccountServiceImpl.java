package doan.flamebackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Account;
import doan.flamebackend.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public void deleteAccountById(Long accountId) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(accountId);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long accountId) {
		Optional<Account> acc = accountRepository.findById(accountId);
		if (acc.isPresent()) {
			return acc.get();
		}
		throw new EntityNotFoundException("Cant find any account under given ID");
	}

	@Override
	public Account updateAccountById(Account account, Long accountId) {
		// TODO Auto-generated method stub
		Account acc = accountRepository.findById(accountId).get();

		if (Objects.nonNull(account.getFullName()) && !"".equalsIgnoreCase(account.getFullName())) {
			acc.setFullName(account.getFullName());
		}

		if (Objects.nonNull(account.getAddress()) && !"".equalsIgnoreCase(account.getAddress())) {
			acc.setAddress(account.getAddress());
		}

		if (Objects.nonNull(account.getPhone()) && !"".equalsIgnoreCase(account.getPhone())) {
			acc.setPhone(account.getPhone());
		}

		return accountRepository.save(acc);

	}

	@Override
	public Account changePassword(Long accountId) {
		// TODO Auto-generated method stub
		Account acc = accountRepository.findByAccountId(accountId);
		if (Objects.nonNull(acc.getPassWord()) && !"".equalsIgnoreCase(acc.getPassWord())) {
			acc.setPassWord(passwordEncoder.encode(acc.getPassWord()));
			accountRepository.save(acc);
		}
		return acc;
	}
}