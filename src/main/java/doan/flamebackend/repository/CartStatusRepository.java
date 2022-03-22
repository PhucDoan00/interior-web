package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.CartStatus;

@Repository
public interface CartStatusRepository extends JpaRepository<CartStatus, Long> {
	CartStatus findByCartStatus(long sttId);
}
