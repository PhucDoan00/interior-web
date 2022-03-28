package doan.flamebackend.demo1.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestAPI {

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('ADMIN') or hasRole('STAFF') or hasRole('CUSTOMER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/customer")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String customerAccess() {
		return "Customer Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

	@GetMapping("/staff")
	@PreAuthorize("hasRole('STAFF')")
	public String staffAccess() {
		return "Staff Board.";
	}
}
