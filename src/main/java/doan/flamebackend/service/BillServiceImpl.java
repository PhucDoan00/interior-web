package doan.flamebackend.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Bill;
import doan.flamebackend.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill getByBillId(Long billId) {
		// TODO Auto-generated method stub
		Optional<Bill> b = billRepository.findById(billId);
		if (b.isPresent()) {
			return b.get();
		}
		throw new EntityNotFoundException("Cant find any bill under given ID");
	}

	@Override
	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

}
