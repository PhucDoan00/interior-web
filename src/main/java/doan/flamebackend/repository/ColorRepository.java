package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
	Color findbyColorId(long colorId);
}
