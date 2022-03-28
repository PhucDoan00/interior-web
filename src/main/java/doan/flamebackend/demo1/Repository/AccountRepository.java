package doan.flamebackend.demo1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.demo1.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findById(Long account_id);

	Optional<Account> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
