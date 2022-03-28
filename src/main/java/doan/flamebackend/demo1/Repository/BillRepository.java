package doan.flamebackend.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.demo1.Entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	
}
