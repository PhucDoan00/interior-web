package doan.flamebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByProductId(Long productId);

	List<Product> findAll();
}
