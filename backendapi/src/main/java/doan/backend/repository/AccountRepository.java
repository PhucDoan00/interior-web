package doan.backend.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Account;
import doan.backend.entity.Feedback;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByEmail(String email);
	
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
    
    @Transactional
	@Query(value = "select * from Account where (name like :param1 or email like :param1 or phone like :param1 or [address] like :param1) and account_id != 1", nativeQuery = true)
	List<Account> searchAccountsNotAdmin (@Param("param1") String param1);
    
    @Transactional
	@Query(value = "select count(*) from Account where email = :param1", nativeQuery = true)
	int countExistEmail (@Param("param1") String param1);
    
    @Transactional
	@Query(value = "select count(*) from Account where account_id = :param1", nativeQuery = true)
	int countExistID (@Param("param1") long param1);
}
