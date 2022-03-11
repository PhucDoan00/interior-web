package doan.flamebackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Feedback;
import doan.flamebackend.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Feedback getByFeedbackId(Long fbId) {
		// TODO Auto-generated method stub
		Optional<Feedback> f = feedbackRepository.findById(fbId);
		if (f.isPresent()) {
			return f.get();
		}
		throw new EntityNotFoundException("Cant find any product under given ID");
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback updateFeedbackById(Feedback fb, Long fbId) {
		// TODO Auto-generated method stub
		Feedback f = feedbackRepository.findById(fbId).get();
		if (Objects.nonNull(f.getFbTitle())) {
			f.setFbTitle(fb.getFbTitle());
		}
		if (Objects.nonNull(f.getFbContent())) {
			f.setFbContent(fb.getFbContent());
		}
		return feedbackRepository.save(f);
	}

	@Override
	public void deleteFeedbackById(Long fbId) {
		// TODO Auto-generated method stub
		feedbackRepository.deleteById(fbId);
	}

}
