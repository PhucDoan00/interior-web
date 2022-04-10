package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.DesignIdea;

public interface DesignIdeaRepository extends JpaRepository<DesignIdea, Long>{

	@Transactional
	@Query(value = "select * from design_idea where category = :param1 and style = :param2", nativeQuery = true)
	List<DesignIdea> getDesignIdeaList (@Param("param1") long param1,
										  @Param("param2") long param2);
	
	@Transactional
	@Query(value = "select * from design_idea_item where idea_id = :param1", nativeQuery = true)
	Iterable<Object[]> getDesignIdeaItems (@Param("param1") long param1);
}
