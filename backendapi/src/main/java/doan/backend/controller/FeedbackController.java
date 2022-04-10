package doan.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.entity.Account;
import doan.backend.entity.Feedback;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/v1")
public class FeedbackController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@PostMapping("/feedback")
	public ResponseEntity<?> createFeedback(@RequestBody String fbContent, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));
		long customerId = account.getAccountId();
		
		if (fbContent == null || fbContent.equals("")) return new ResponseEntity<>("Feedback cannot be empty!", HttpStatus.BAD_REQUEST);
		
		Feedback feedback = new Feedback();
		feedback.setCustomerId(customerId);
		feedback.setFbContent(fbContent);
		java.util.Date date = new java.util.Date();   
		System.out.println(date);
		feedback.setCreatedAt(date);
		
		feedbackRepository.save(feedback);
		
		return new ResponseEntity<>("Feedback added!", HttpStatus.OK);
	}
}
