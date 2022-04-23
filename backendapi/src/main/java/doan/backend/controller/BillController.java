package doan.backend.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.CartItemDTO;
import doan.backend.dto.ViewBillDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Bill;
import doan.backend.entity.Cart;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.BillRepository;
import doan.backend.repository.BillStatusRepository;
import doan.backend.repository.CartRepository;
import doan.backend.repository.ProductRepository;
import doan.backend.service.CartService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class BillController {

	private static final DecimalFormat dfZero = new DecimalFormat("0.00");
	SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillStatusRepository billStatusRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	//CUSTOMER - View All Personal Bills
	@GetMapping("/viewbill")
	public ResponseEntity<?> viewBillList(HttpServletRequest request) throws ParseException {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.OK);
    	Account acc = accountRepository.findByEmail(email);
    	
    	int count = billRepository.countBills(acc.getAccountId());
		if (count == 0) return new ResponseEntity<>("You have no bills!", HttpStatus.OK);
		List<ViewBillDTO> viewbills = new ArrayList<ViewBillDTO>();
		List<Bill> bills = billRepository.findAll();
		
		for (Bill bill : bills) {
			ViewBillDTO viewbill = new ViewBillDTO();
			viewbill.setBillId(bill.getBillId());
			viewbill.setCartId(bill.getCartId());
			viewbill.setBillStatus(billStatusRepository.getById(bill.getBillStatus()).getStatus());

			List<CartItemDTO> items = cartService.getItemsInCart(bill.getCartId());
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
			}
			viewbill.setProductTotal(result);
			
			double fee = result * 0.1;
			viewbill.setShippingFee(Float.parseFloat(dfZero.format(fee)));
			
			viewbill.setTotalPrice(bill.getProductTotal() + bill.getShippingFee());
			viewbill.setCustomerName(bill.getCustomerName());
			viewbill.setPhone(bill.getPhone());
			viewbill.setEmail(bill.getEmail());
			viewbill.setAddress(bill.getAddress());
			viewbill.setPurchasedAt(formatter.format(bill.getPurchasedAt()));
			viewbill.setCartItem(items);
			
			viewbills.add(viewbill);
		}
		
		return new ResponseEntity<List<ViewBillDTO>> (viewbills, HttpStatus.OK);
	}
	
	//CUSTOMER - View 1 Bill's Details
	@GetMapping("/viewbill/{id}")
	public ResponseEntity<?> viewBill(HttpServletRequest request, @PathVariable(value = "id") Long billId) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.OK);
    	Account acc = accountRepository.findByEmail(email);
    	
    	Bill bill = billRepository.getById(billId);
		long customerId = cartRepository.getById(bill.getCartId()).getCustomerId();
		if (acc.getAccountId() != customerId) return new ResponseEntity<>("You cannot view this bill!", HttpStatus.OK);
		ViewBillDTO viewbill = new ViewBillDTO();
		
		viewbill.setBillId(bill.getBillId());
		viewbill.setCartId(bill.getCartId());
		viewbill.setBillStatus(billStatusRepository.getById(bill.getBillStatus()).getStatus());
		viewbill.setProductTotal(Float.parseFloat(dfZero.format(bill.getProductTotal())));
		viewbill.setShippingFee(Float.parseFloat(dfZero.format(bill.getShippingFee())));
		viewbill.setTotalPrice(Float.parseFloat(dfZero.format(bill.getTotalPrice())));
		viewbill.setCustomerName(bill.getCustomerName());
		viewbill.setPhone(bill.getPhone());
		viewbill.setEmail(bill.getEmail());
		viewbill.setAddress(bill.getAddress());
		viewbill.setPurchasedAt(formatter.format(bill.getPurchasedAt()));
		
		List<CartItemDTO> items = cartService.getItemsInCart(bill.getCartId());
		viewbill.setCartItem(items);
		
		return new ResponseEntity<ViewBillDTO> (viewbill, HttpStatus.OK);
	}
	
	//CUSTOMER - Cancel Bill (Only Be Able to Cancel Bills Are NOT SHIPPING YET)
	@PutMapping("/viewbill/{id}")
	public ResponseEntity<?> cancelBill(HttpServletRequest request, @PathVariable(value = "id") Long billId) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.OK);
    	Account acc = accountRepository.findByEmail(email);
    	
    	Bill bill = billRepository.getById(billId);
		long customerId = cartRepository.getById(bill.getCartId()).getCustomerId();
		if (acc.getAccountId() != customerId) return new ResponseEntity<>("You cannot cancel this bill!", HttpStatus.OK);
		if (bill.getBillStatus() != 1) return new ResponseEntity<>("You cannot cancel this bill!", HttpStatus.OK);
		billRepository.updateBillStatus(2, billId);
		return new ResponseEntity<>("Cancel Successfully!", HttpStatus.OK);
	}
	
	//ADMIN + STAFF - View All Customers' Bills
	@GetMapping("/viewallbills")
	public ResponseEntity<?> viewAllBill() throws ParseException {
		
		List<ViewBillDTO> viewbills = new ArrayList<ViewBillDTO>();
		List<Bill> bills = billRepository.findAll();
		
		for (Bill bill : bills) {
			ViewBillDTO viewbill = new ViewBillDTO();
			viewbill.setBillId(bill.getBillId());
			viewbill.setCartId(bill.getCartId());
			viewbill.setBillStatus(billStatusRepository.getById(bill.getBillStatus()).getStatus());

			List<CartItemDTO> items = cartService.getItemsInCart(bill.getCartId());
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
			}
			viewbill.setProductTotal(result);
			
			double fee = result * 0.1;
			viewbill.setShippingFee(Float.parseFloat(dfZero.format(fee)));
			
			viewbill.setTotalPrice(bill.getProductTotal() + bill.getShippingFee());
			viewbill.setCustomerName(bill.getCustomerName());
			viewbill.setPhone(bill.getPhone());
			viewbill.setEmail(bill.getEmail());
			viewbill.setAddress(bill.getAddress());
			viewbill.setPurchasedAt(formatter.format(bill.getPurchasedAt()));
			viewbill.setCartItem(items);
			
			viewbills.add(viewbill);
		}
		
		return new ResponseEntity<List<ViewBillDTO>> (viewbills, HttpStatus.OK);
	}
	
	//ADMIN + STAFF - Search Bar In Manage Bill Page
	@GetMapping("/viewallbills/search")
	public ResponseEntity<?> viewAllBillSearch(@RequestBody String searchString) throws ParseException {
		
		List<ViewBillDTO> viewbills = new ArrayList<ViewBillDTO>();
		String finalString = "%" + searchString + "%";
		List<Bill> bills = billRepository.searchBills(finalString, finalString);
		
		for (Bill bill : bills) {
			ViewBillDTO viewbill = new ViewBillDTO();
			viewbill.setBillId(bill.getBillId());
			viewbill.setCartId(bill.getCartId());
			viewbill.setBillStatus(billStatusRepository.getById(bill.getBillStatus()).getStatus());

			List<CartItemDTO> items = cartService.getItemsInCart(bill.getCartId());
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
			}
			viewbill.setProductTotal(result);
			
			double fee = result * 0.1;
			viewbill.setShippingFee(Float.parseFloat(dfZero.format(fee)));
			
			viewbill.setTotalPrice(bill.getProductTotal() + bill.getShippingFee());
			viewbill.setCustomerName(bill.getCustomerName());
			viewbill.setPhone(bill.getPhone());
			viewbill.setEmail(bill.getEmail());
			viewbill.setAddress(bill.getAddress());
			viewbill.setPurchasedAt(formatter.format(bill.getPurchasedAt()));
			viewbill.setCartItem(items);
			
			viewbills.add(viewbill);
		}
		
		return new ResponseEntity<List<ViewBillDTO>> (viewbills, HttpStatus.OK);
	}
	
	//ADMIN + STAFF - Get 1 Bill's Details
	@GetMapping("/viewallbills/{id}")
	public ResponseEntity<?> viewOneBill(@PathVariable(value = "id") Long billId) throws ParseException {
		Bill bill = billRepository.getById(billId);
		ViewBillDTO viewbill = new ViewBillDTO();
		
		viewbill.setBillId(bill.getBillId());
		viewbill.setCartId(bill.getCartId());
		viewbill.setBillStatus(billStatusRepository.getById(bill.getBillStatus()).getStatus());
		viewbill.setProductTotal(Float.parseFloat(dfZero.format(bill.getProductTotal())));
		viewbill.setShippingFee(Float.parseFloat(dfZero.format(bill.getShippingFee())));
		viewbill.setTotalPrice(Float.parseFloat(dfZero.format(bill.getTotalPrice())));
		viewbill.setCustomerName(bill.getCustomerName());
		viewbill.setPhone(bill.getPhone());
		viewbill.setEmail(bill.getEmail());
		viewbill.setAddress(bill.getAddress());
		viewbill.setPurchasedAt(formatter.format(bill.getPurchasedAt()));
		
		List<CartItemDTO> items = cartService.getItemsInCart(bill.getCartId());
		viewbill.setCartItem(items);
		
		return new ResponseEntity<ViewBillDTO> (viewbill, HttpStatus.OK);
	}
	
	//ADMIN + STAFF - Edit Bills' Status (Only Be Able To Update Bills Are NOT CANCEL)
	@PutMapping("/viewallbills/{id}")
	public ResponseEntity<?> updateBillStatus(@PathVariable(value = "id") Long billId, @RequestBody Long statusId) throws ParseException {
		if (statusId > 4) return new ResponseEntity<> ("This Status is not Available", HttpStatus.OK);
		Bill bill = billRepository.getById(billId);
		long currentStt = bill.getBillStatus();
		
		if (currentStt == 2 || currentStt == 4) return new ResponseEntity<> ("This bill cannot be updated!", HttpStatus.OK);
		
		billRepository.updateBillStatus(statusId, billId);
		return new ResponseEntity<> ("Updated Successful!", HttpStatus.OK);
	}
	
	//CUSTOMER - Checkout the Items In Current Cart + Create Bill
	@GetMapping("/checkout")
	public ResponseEntity<?> checkout(HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.OK);
    	Account account = accountRepository.findByEmail(email);
    	long customerId = account.getAccountId();
		
		int count = cartRepository.countAvailableCart(customerId);
		
		if (count == 0) return new ResponseEntity<>("You need at least 1 item to checkout!", HttpStatus.OK);
		else {
			Cart cart = cartRepository.findActiveCartByCustomerId(customerId);
			List<CartItemDTO> items = cartService.getItemsInCart(cart.getCartId());
			
			int invalidItem = 0;
			for (CartItemDTO item : items) {
				long itemId = item.getProductId();
				if (item.getQuantity() > productRepository.getById(itemId).getQuantity()) invalidItem++;
			}
			if (invalidItem > 0) return new ResponseEntity<>("There are item(s) in your cart that we don't have enough quantity", HttpStatus.OK);
			
			Bill bill = new Bill();
			
			bill.setCartId(cart.getCartId());
			bill.setBillStatus((long)1);
			
			float result = 0;
			for (CartItemDTO item : items) {
				result += item.getPrice() * item.getQuantity();
				
				int preQuantity = productRepository.getById(item.getProductId()).getQuantity();
				productRepository.editProductQuantity(preQuantity - item.getQuantity(), item.getProductId());
				productRepository.editProductBoughtCount(productRepository.getById(item.getProductId()).getBoughtCount() + item.getQuantity(), item.getProductId());
			}
			bill.setProductTotal(result);
			
			double fee = result * 0.1;
			bill.setShippingFee(Float.parseFloat(dfZero.format(fee)));
			
			bill.setTotalPrice(bill.getProductTotal() + bill.getShippingFee());
			bill.setCustomerName(account.getName());
			bill.setPhone(cart.getPhone());
			bill.setEmail(cart.getEmail());
			bill.setAddress(cart.getAddress());
			java.util.Date date = new java.util.Date();   
			System.out.println(date);
			bill.setPurchasedAt(date);
		
			billRepository.save(bill);
			
			cartRepository.updateCartStatus(3, cart.getCartId());
		return new ResponseEntity<>("Purchase Successful!", HttpStatus.OK);
		}
	}
}
