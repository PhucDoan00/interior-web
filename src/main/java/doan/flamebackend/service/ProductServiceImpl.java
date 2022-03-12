package doan.flamebackend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.flamebackend.entity.Product;
import doan.flamebackend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getByProductId(Long productId) {
		// TODO Auto-generated method stub
		Optional<Product> p = productRepository.findById(productId);
		if (p.isPresent()) {
			return p.get();
		}
		throw new EntityNotFoundException("Cant find any product under given ID");
	}

	@Override
	public Product updateProductById(Product product, Long productId) {
		// TODO Auto-generated method stub
		Product p = productRepository.findById(productId).get();

		if (Objects.nonNull(p.getProductName()) && !"".equalsIgnoreCase(p.getProductName())) {
			p.setProductName(p.getProductName());
		}

		if (Objects.nonNull(p.getPrice())) {
			p.setPrice(p.getPrice());
		}
		if (Objects.nonNull(p.getQuantity())) {
			p.setQuantity(p.getQuantity());
		}
		if (Objects.nonNull(p.getImage()) && !"".equalsIgnoreCase(p.getImage())) {
			p.setImage(p.getImage());
		}
		if (Objects.nonNull(p.getDescription()) && !"".equalsIgnoreCase(p.getDescription())) {
			p.setDescription(p.getDescription());
		}
		if (Objects.nonNull(p.getMaterial()) && !"".equalsIgnoreCase(p.getMaterial())) {
			p.setMaterial(p.getMaterial());
		}
		if (Objects.nonNull(p.getDimension()) && !"".equalsIgnoreCase(p.getDimension())) {
			p.setDimension(p.getDimension());
		}
		return productRepository.save(p);
	}

	@Override
	public void deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

}
