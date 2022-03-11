package doan.flamebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doan.flamebackend.entity.Product;
import doan.flamebackend.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductAPI {

	@Autowired
	private ProductService productService;

	@GetMapping()
	public ResponseEntity<?> getAllProducts(@RequestParam(required = false) Long productId) {
		if (productId == null) {
			return ResponseEntity.ok(productService.getAllProducts());
		}
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{ProductId}/")
	public ResponseEntity<Product> getProductByProductId(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.getByProductId(productId));
	}

	@PutMapping("/{ProductId}/update")
	public Product updateProductById(@RequestBody Product product, @PathVariable Long productId) {
		return productService.updateProductById(product, productId);
	}

	@DeleteMapping("/{ProductId}/delete")
	public ResponseEntity<?> deleteProductById(@PathVariable Long productId) {
		productService.deleteProductById(productId);
		return ResponseEntity.ok().build();
	}
}
