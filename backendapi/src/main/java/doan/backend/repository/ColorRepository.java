package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long>{

	@Transactional
	@Query(value = "select Color.color_id, Color.color_name from Color inner join product_color on Color.color_id = product_color.color_id"
			+ "	where product_color.product_id = :param1", nativeQuery = true)
	List<Color> productColor(@Param("param1") long param1);
}
