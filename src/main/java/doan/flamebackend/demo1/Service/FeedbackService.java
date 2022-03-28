package doan.flamebackend.demo1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.demo1.Entity.Feedback;

@Service
public interface FeedbackService {
	List<Feedback> getAllFeedbacks();
}
