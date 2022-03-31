package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import doan.backend.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Transactional
	@Query(value = "select top 5* from Product order by bought_count desc", nativeQuery = true)
	List<Product> getTop5();
	
	List<Product> findAll();
	
	Product getOne(long id);
}
