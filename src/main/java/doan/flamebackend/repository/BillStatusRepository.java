package doan.flamebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.BillStatus;

@Repository
public interface BillStatusRepository extends JpaRepository<BillStatus, Long> {
	List<BillStatus> findByBillStatusId(Long sttId);
}
