package doan.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doan.backend.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

}
