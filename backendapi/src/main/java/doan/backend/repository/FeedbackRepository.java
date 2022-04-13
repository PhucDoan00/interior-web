package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	@Transactional
	@Query(value = "select Feedback.fb_id, Feedback.customer_id, Feedback.fb_content, Feedback.created_at "
			+ "from Feedback inner join Account on Feedback.customer_id = Account.account_id where Account.name like :param1 or Account.address like :param1 or Feedback.fb_content like :param1", nativeQuery = true)
	List<Feedback> searchFeedbacks (@Param("param1") String param1);
}
