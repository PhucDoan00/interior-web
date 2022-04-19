package doan.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doan.backend.entity.BillStatus;

public interface BillStatusRepository extends JpaRepository<BillStatus, Long>{

}
