package doan.flamebackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Feedback;

@Service
public interface FeedbackService {

	Feedback getByFeedbackId(Long fbId);

	List<Feedback> getAllFeedbacks();

	Feedback updateFeedbackById(Feedback fb, Long fbId);

	void deleteFeedbackById(Long fbId);
}
