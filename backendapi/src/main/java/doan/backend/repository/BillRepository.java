package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

	@Transactional
	@Query(value = "select count(*) from Bill inner join Cart on Bill.cart_id = Cart.cart_id where Cart.customer_id = :param1", nativeQuery = true)
	int countBills (@Param("param1") long param1);
	
	@Transactional
	@Modifying
	@Query(value = "update Bill set bill_status = :param1 where bill_id = :param2", nativeQuery = true)
	void updateBillStatus(@Param("param1") long param1,
						  @Param("param2") long param2);
	
	@Transactional
	@Query(value = "select * from Bill where customer_name like :param1 or phone like :param2", nativeQuery = true)
	List<Bill> searchBills (@Param("param1") String param1,
							@Param("param2") String param2);
}
