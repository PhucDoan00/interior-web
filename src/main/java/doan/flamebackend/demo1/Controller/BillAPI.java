package doan.flamebackend.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.demo1.Service.BillService;

@RestController
@RequestMapping(path = "api/bills")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BillAPI {

	private BillService billService;

	@Autowired
	public BillAPI(BillService billService) {
		this.billService = billService;
	}

	@GetMapping("/bills")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAllBills(@RequestParam(required = false) Long bill_id) {
		if (bill_id == null) {
			return ResponseEntity.ok(billService.getAllBills());
		}
		return ResponseEntity.ok(billService.getAllBills());
	}
}
