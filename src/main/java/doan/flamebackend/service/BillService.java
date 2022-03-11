package doan.flamebackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Bill;

@Service
public interface BillService {
	Bill getByBillId(Long billId);

	List<Bill> getAllBills();
}
