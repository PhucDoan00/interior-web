package doan.flamebackend.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.demo1.Service.FeedbackService;

@RestController
@RequestMapping(path = "api/feedbacks")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeedbackAPI {

	private FeedbackService feedbackService;

	@Autowired
	public FeedbackAPI(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@GetMapping("/fbs")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllFeedbacks(@RequestParam(required = false) Long fb_id) {
		if (fb_id == null) {
			return ResponseEntity.ok(feedbackService.getAllFeedbacks());
		}
		return ResponseEntity.ok(feedbackService.getAllFeedbacks());
	}
}
