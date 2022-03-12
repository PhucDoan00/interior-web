package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.ProductColor;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
	ProductColor findByProductColorId(long productId);
}
