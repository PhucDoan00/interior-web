package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.DesignIdea;

@Repository
public interface DesignIdeaRepository extends JpaRepository<DesignIdea, Long> {
	DesignIdea findByDesignIdeaId(long ideaId);
}
