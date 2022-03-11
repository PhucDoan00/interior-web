package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByCategoryId(long categoryId);
}
