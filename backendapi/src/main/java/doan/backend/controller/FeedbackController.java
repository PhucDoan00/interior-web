package doan.backend.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.FeedbackDTO;
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
	
	SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
	
	@PostMapping("/feedback")
	public ResponseEntity<?> createFeedback(@RequestBody String fbContent, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
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
	
	@GetMapping("/feedback/view")
	public ResponseEntity<?> getAllFeedback(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
		List<FeedbackDTO> finalList = new ArrayList<FeedbackDTO>();
		List<Feedback> list = feedbackRepository.findAll();
		
		if (list.size() == 0) return new ResponseEntity<>("No feedbacks available!", HttpStatus.OK);
		for (Feedback feedback : list) {
			FeedbackDTO fb = new FeedbackDTO();
			fb.setFbId(feedback.getFbId());
			fb.setCustomerId(feedback.getCustomerId());
			fb.setCustomerName(accountRepository.getById(feedback.getCustomerId()).getName());
			fb.setFbContent(feedback.getFbContent());
			fb.setPhone(accountRepository.getById(feedback.getCustomerId()).getPhone());
			fb.setAddress(accountRepository.getById(feedback.getCustomerId()).getAddress());
			fb.setEmail(accountRepository.getById(feedback.getCustomerId()).getEmail());
			fb.setCreatedDate(formatter.format(feedback.getCreatedAt()));
			finalList.add(fb);
		}

		return new ResponseEntity<List<FeedbackDTO>>(finalList, HttpStatus.OK);
	}
	
	@GetMapping("/feedback/view/{id}")
	public ResponseEntity<?> viewOneFeedback(HttpServletRequest request, @PathVariable(value = "id") Long fbId) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
		
		Feedback feedback = feedbackRepository.getById(fbId);
		
		if (feedback.getFbContent() == null || feedback.getFbContent().equals("")) return new ResponseEntity<>("Feedback not found with ID: " + fbId, HttpStatus.OK);
		FeedbackDTO fb = new FeedbackDTO();
		
		
			fb.setFbId(feedback.getFbId());
			fb.setCustomerId(feedback.getCustomerId());
			fb.setCustomerName(accountRepository.getById(feedback.getCustomerId()).getName());
			fb.setFbContent(feedback.getFbContent());
			fb.setPhone(accountRepository.getById(feedback.getCustomerId()).getPhone());
			fb.setAddress(accountRepository.getById(feedback.getCustomerId()).getAddress());
			fb.setEmail(accountRepository.getById(feedback.getCustomerId()).getEmail());
			fb.setCreatedDate(formatter.format(feedback.getCreatedAt()));
			

		return new ResponseEntity<FeedbackDTO>(fb, HttpStatus.OK);
	}
	
	@DeleteMapping("/feedback/view/{id}")
	public ResponseEntity<?> deleteFeedback(HttpServletRequest request, @PathVariable(value = "id") Long fbId) {
		String email = request.getUserPrincipal().getName();
		Account account = accountRepository.findByEmail(email) 
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
		
		feedbackRepository.deleteById(fbId);
		return new ResponseEntity<>("Feedback Deleted!", HttpStatus.OK);
	}
}
