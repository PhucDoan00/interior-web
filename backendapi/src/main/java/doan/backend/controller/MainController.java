package doan.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.entity.Product;
import doan.backend.repository.ProductRepository;

@RestController
@RequestMapping("/")
public class MainController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> index() {
        return new ResponseEntity<List<Product>>(productRepository.getTop5(), HttpStatus.OK);
    }
	
}
