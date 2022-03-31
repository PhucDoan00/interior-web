package doan.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import doan.backend.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByEmail(String email);
	
    Boolean existsByEmail(String email);

}
