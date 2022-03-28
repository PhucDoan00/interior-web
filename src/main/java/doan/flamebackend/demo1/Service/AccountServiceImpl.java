package doan.flamebackend.demo1.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import doan.flamebackend.demo1.Entity.Account;
import doan.flamebackend.demo1.Repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	PasswordEncoder passwordEncoder;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long account_id) {
		Optional<Account> acc = accountRepository.findById(account_id);
		if (acc.isPresent()) {
			return acc.get();
		}
		throw new EntityNotFoundException("Cant find any account under given ID");
	}

	@Override
	public Account updateAccountById(Account account, Long account_id) {
		Account acc = accountRepository.findById(account_id).get();

		if (Objects.nonNull(account.getName()) && !"".equalsIgnoreCase(account.getName())) {
			acc.setName(account.getName());
		}

		if (Objects.nonNull(account.getUsername()) && !"".equalsIgnoreCase(account.getUsername())) {
			acc.setUsername(account.getUsername());
		}

		if (Objects.nonNull(account.getAddress()) && !"".equalsIgnoreCase(account.getAddress())) {
			acc.setAddress(account.getAddress());
		}

		if (Objects.nonNull(account.getPhone()) && !"".equalsIgnoreCase(account.getPhone())) {
			acc.setPhone(account.getPhone());
		}

		if (Objects.nonNull(account.getPassword()) && !"".equalsIgnoreCase(account.getPassword())) {
			acc.setPassword(passwordEncoder.encode(account.getPassword()));
		}

		return accountRepository.save(acc);
	}

	@Override
	public void deleteAccountById(Long account_id) {
		accountRepository.deleteById(account_id);
	}
}
