package doan.flamebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.entity.Bill;
import doan.flamebackend.service.BillService;

@RestController
@RequestMapping(path = "/api/bills")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BillAPI {

	@Autowired
	private BillService billService;

	@GetMapping()
	public ResponseEntity<?> getAllBills(@RequestParam(required = false) Long billId) {
		if (billId == null) {
			return ResponseEntity.ok(billService.getAllBills());
		}
		return ResponseEntity.ok(billService.getAllBills());
	}

	@GetMapping("/{BillId}/")
	public ResponseEntity<Bill> getBillByBillId(@PathVariable Long billId) {
		return ResponseEntity.ok(billService.getByBillId(billId));
	}
}
