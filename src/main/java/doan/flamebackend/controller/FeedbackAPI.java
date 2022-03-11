package doan.flamebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.entity.Feedback;
import doan.flamebackend.service.FeedbackService;

@RestController
@RequestMapping(path = "/api/feedbacks")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeedbackAPI {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping()
	public ResponseEntity<?> getAllFeedbacks(@RequestParam(required = false) Long fbId) {
		if (fbId == null) {
			return ResponseEntity.ok(feedbackService.getAllFeedbacks());
		}
		return ResponseEntity.ok(feedbackService.getAllFeedbacks());
	}

	@GetMapping("/{FbId}/")
	public ResponseEntity<Feedback> getFeedbackByFeedbackId(@PathVariable Long fbId) {
		return ResponseEntity.ok(feedbackService.getByFeedbackId(fbId));
	}

	@PutMapping("/{FbId}/update")
	public Feedback updateFeedbackById(@RequestBody Feedback fb, @PathVariable Long fbId) {
		return feedbackService.updateFeedbackById(fb, fbId);
	}

	@DeleteMapping("/{FbId}/delete")
	public ResponseEntity<?> deleteFeedbackById(@PathVariable Long fbId) {
		feedbackService.deleteFeedbackById(fbId);
		return ResponseEntity.ok().build();
	}
}
