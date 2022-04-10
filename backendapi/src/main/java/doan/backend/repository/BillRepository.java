package doan.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doan.backend.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
