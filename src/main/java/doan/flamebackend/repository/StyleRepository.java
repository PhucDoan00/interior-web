package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
	Style findByStyleId(long styleId);
}
