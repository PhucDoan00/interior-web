package doan.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Product> index() {
        return productRepository.getTop5();
    }
	
}
