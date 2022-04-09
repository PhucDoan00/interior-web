package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Category;
import doan.backend.entity.Color;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Transactional
	@Query(value = "select Category.category_id, Category.category_name from Category inner join product_category on Category.category_id = product_category.category_id"
			+ " where product_category.product_id = :param1", nativeQuery = true)
	List<Category> productCategory(@Param("param1") long param1);
}
