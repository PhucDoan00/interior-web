package doan.flamebackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountId(Long accountId);

	Optional<Account> findByEmail(String email);

	Boolean existsByAccountId(long accountId);

	Boolean existsByEmail(String email);

}
