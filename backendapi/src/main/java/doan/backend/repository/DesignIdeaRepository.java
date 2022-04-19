package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.DesignIdea;
import doan.backend.entity.Product;

public interface DesignIdeaRepository extends JpaRepository<DesignIdea, Long>{

	@Transactional
	@Query(value = "select * from design_idea where category = :param1 and style = :param2", nativeQuery = true)
	List<DesignIdea> getDesignIdeaList (@Param("param1") long param1,
										  @Param("param2") long param2);
	
	@Transactional
	@Query(value = "select * from design_idea_item where idea_id = :param1", nativeQuery = true)
	Iterable<Object[]> getDesignIdeaItems (@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select top 1* from design_idea order by idea_id desc", nativeQuery = true)
	DesignIdea getNewestIdea();
	
	@Transactional
	@Modifying
	@Query(value = "insert into design_idea_item(idea_id, product_id) values (:param1, :param2)", nativeQuery = true)
	void insertIdeaItem(@Param("param1") long param1,
				 		@Param("param2") long param2);
	
	@Transactional
	@Modifying
	@Query(value = "update design_idea "
			+ "set idea_name = :param1, [description] = :param2, category = :param3, style = :param4, image = :param5 "
			+ "where idea_id = :param6", nativeQuery = true)
	void updateDesignIdea(@Param("param1") String param1,
				 		  @Param("param2") String param2,
				 		  @Param("param3") long param3,
				 		  @Param("param4") long param4,
				 		  @Param("param5") String param5,
				 		  @Param("param6") long param6);
	
	@Transactional
	@Modifying
	@Query(value = "delete from design_idea_item where idea_id = :param1", nativeQuery = true)
	void deleteIdeaItem(@Param("param1") long param1);
}
