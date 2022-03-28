package doan.flamebackend.demo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.flamebackend.demo1.Entity.Bill;
import doan.flamebackend.demo1.Repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	
	private BillRepository billRepository;

	@Autowired
	public BillServiceImpl(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

}
