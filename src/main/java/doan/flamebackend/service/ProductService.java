package doan.flamebackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Product;

@Service
public interface ProductService {
	Product getByProductId(Long productId);

	Product updateProductById(Product product, Long productId);

	List<Product> getAllProducts();

	void deleteProductById(Long productId);

}
