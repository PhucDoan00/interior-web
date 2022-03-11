package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
//	Bill findByBillId(Long billId);
//
//	List<Bill> getAllBills();
}
