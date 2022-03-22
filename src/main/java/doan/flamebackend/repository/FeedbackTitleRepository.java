package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.FeedbackTitle;

@Repository
public interface FeedbackTitleRepository extends JpaRepository<FeedbackTitle, Long> {
	FeedbackTitle findByFeedbackTitleId(long fbTitleId);
}
