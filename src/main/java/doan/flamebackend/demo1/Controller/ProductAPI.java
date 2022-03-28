package doan.flamebackend.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.demo1.Service.ProductService;

@RestController
@RequestMapping(path = "api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductAPI {
	private ProductService productService;
	
	@Autowired
	public ProductAPI(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	@PreAuthorize("hasRole('ADMIN') and hasRole('STAFF') and hasRole('CUSTOMER')")
	public ResponseEntity<?> getAllProducts(@RequestParam(required = false) Long product_id) {
		if (product_id == null) {
			return ResponseEntity.ok(productService.getAllProducts());
		}
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
