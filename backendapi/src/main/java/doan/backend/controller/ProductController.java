package doan.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.ProductInformationDTO;
import doan.backend.entity.Category;
import doan.backend.entity.Color;
import doan.backend.entity.Product;
import doan.backend.exception.ResourceNotFoundException;
import doan.backend.repository.CategoryRepository;
import doan.backend.repository.ColorRepository;
import doan.backend.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		System.out.println(productRepository.findAll());
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductInformationDTO> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id: " + productId));
		ProductInformationDTO info = new ProductInformationDTO();
		
		info.setProductId(productId);
		info.setProductName(product.getProductName());
		info.setPrice(product.getPrice());
		info.setQuantity(product.getQuantity());
		info.setImage(product.getImage());
		info.setDescription(product.getDescription());
		info.setBoughtCount(product.getBoughtCount());
		info.setMaterial(product.getMaterial());
		info.setDimension(product.getDimension());
		List<Color> color = colorRepository.productColor(productId);
		List<String> colorString = new ArrayList<String>();
		for (int i = 0; i < color.size(); i++) {
			colorString.add(color.get(i).getColorName());
		}
		info.setColors(colorString);
		
		List<Category> category = categoryRepository.productCategory(productId);
		List<String> categoryString = new ArrayList<String>();
		for (int i = 0; i < category.size(); i++) {
			categoryString.add(category.get(i).getCategoryName());
		}
		info.setCategories(categoryString);

		return ResponseEntity.ok().body(info);
	}

}
