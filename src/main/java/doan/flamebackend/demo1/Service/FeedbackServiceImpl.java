package doan.flamebackend.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.flamebackend.demo1.Entity.Feedback;
import doan.flamebackend.demo1.Repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	private FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

}
