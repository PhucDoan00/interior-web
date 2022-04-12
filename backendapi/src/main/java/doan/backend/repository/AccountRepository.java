package doan.backend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByEmail(String email);
	
    Boolean existsByEmail(String email);

    @Transactional
	@Modifying
	@Query(value = "update Account "
			+ "set name = :param1, phone = :param2, email = :param3, [address] = :param4 "
			+ "where account_id = :param5", nativeQuery = true)
	void updateAccountInfo(@Param("param1") String param1,
						   @Param("param2") String param2,
						   @Param("param3") String param3,
						   @Param("param4") String param4,
						   @Param("param5") long param5);
    
    @Transactional
	@Modifying
	@Query(value = "delete from account_role where account_id = :param1 "
			+ "delete from Account where account_id = :param1", nativeQuery = true)
	void deleteAccount(@Param("param1") long param1);
    
    @Transactional
	@Modifying
	@Query(value = "update Account set password = :param1 "
			+ "where account_id = :param2", nativeQuery = true)
	void changePassword(@Param("param1") String param1,
						@Param("param2") long param2);
}
