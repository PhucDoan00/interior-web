package doan.backend.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.ColorsAndCategoriesDTO;
import doan.backend.dto.CreateProductDTO;
import doan.backend.dto.ProductInformationDTO;
import doan.backend.entity.Account;
import doan.backend.entity.Category;
import doan.backend.entity.Color;
import doan.backend.entity.Product;
import doan.backend.exception.ResourceNotFoundException;
import doan.backend.repository.AccountRepository;
import doan.backend.repository.CategoryRepository;
import doan.backend.repository.ColorRepository;
import doan.backend.repository.ProductRepository;
import doan.backend.service.CartService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ColorRepository colorRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CartService cartService;
	/*
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		System.out.println(productRepository.findAll());
		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
	}
	*/ 
	//Get a List of All Products
	@GetMapping("/products")
	public ResponseEntity<List<ProductInformationDTO>> getAllProducts() {
		/*List<Product> list = productRepository.findAll();*/
		List<Product> list = productRepository.getAll();
		List<ProductInformationDTO> finalList = new ArrayList<ProductInformationDTO>();
		
		for (Product product : list) {
			ProductInformationDTO info = new ProductInformationDTO();
			
			info.setProductId(product.getProductId());
			info.setProductName(product.getProductName());
			info.setPrice(product.getPrice());
			info.setQuantity(product.getQuantity());
			info.setImage(product.getImage());
			info.setDescription(product.getDescription());
			info.setBoughtCount(product.getBoughtCount());
			info.setMaterial(product.getMaterial());
			info.setDimension(product.getDimension());/*
			List<Color> color = colorRepository.productColor(product.getProductId());
			List<String> colorString = new ArrayList<String>();
			for (int i = 0; i < color.size(); i++) {
				colorString.add(color.get(i).getColorName());
			}
			info.setColors(colorString);
			
			List<Category> category = categoryRepository.productCategory(product.getProductId());
			List<String> categoryString = new ArrayList<String>();
			for (int i = 0; i < category.size(); i++) {
				categoryString.add(category.get(i).getCategoryName());
			}
			info.setCategories(categoryString);*/
			
			finalList.add(info);
		}
		
		return new ResponseEntity<List<ProductInformationDTO>>(finalList, HttpStatus.OK);
	}
	
	//View a Product's Details
	@GetMapping("/products/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(value = "id") Long productId){
		int count1 = productRepository.countExistID(productId);
    	if (count1 == 0) return new ResponseEntity<>("Product not found for this id: " + productId, HttpStatus.OK);
		
		Product product = productRepository.getById(productId);
				
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
	
	//CUSTOMER - Add a Product to Cart
	@PostMapping("/products/{id}")
	public ResponseEntity<?> addToCart(@PathVariable(value = "id") Long productId, @RequestBody Integer quantity, HttpServletRequest request) {
		String email = request.getUserPrincipal().getName();
		int count1 = accountRepository.countExistEmail(email);
    	if (count1 == 0) return new ResponseEntity<>("User not found with email: " + email, HttpStatus.OK);
    	Account account = accountRepository.findByEmail(email);
    	
		int i = cartService.addProductToCart(account.getAccountId(), productId, quantity);
		if (i == 0) return new ResponseEntity<>("Product added to cart!", HttpStatus.OK);
		else return new ResponseEntity<>("Product's quantity exceeded!", HttpStatus.OK);
	}

	//STAFF - Get 2 Lists of Colors and Categories in the System (In Create Product Step)
	@GetMapping("/createproduct")
	public ResponseEntity<ColorsAndCategoriesDTO> getAllColorsAndCategories() {
		ColorsAndCategoriesDTO list = new ColorsAndCategoriesDTO();
		list.setColors(colorRepository.findAll());
		list.setCategories(categoryRepository.findAll());
		return new ResponseEntity<ColorsAndCategoriesDTO>(list, HttpStatus.OK);
	}
	
	//STAFF - Create a Product
	@PostMapping("/createproduct")
	public ResponseEntity<?> createProduct(@RequestBody CreateProductDTO product){
		
		productRepository.insertProduct(product.getProductName(), product.getPrice(),
				product.getQuantity(), product.getMaterial(), product.getDimension(),
				product.getImage(), product.getDescription());
		
		Long productId = productRepository.getCreatedProduct().getProductId();
		
		Set<Long> colorIds = product.getColorIds();
		Set<Long> categoryIds = product.getCategoryIds();
		
		for (Long colorId : colorIds) {
			productRepository.insertProductColor(productId, colorId);
		}
		
		for (Long categoryId : categoryIds) {
			productRepository.insertProductCategory(productId, categoryId);
		}
		
		return new ResponseEntity<>("Product successfully created", HttpStatus.OK);
	}
	
	//STAFF - Get a Product's Details (Before Edit Product Step)
	@GetMapping("/editproduct/{id}")
	public ResponseEntity<?> getEditProduct(@PathVariable(value = "id") Long productId){
		int count1 = productRepository.countExistID(productId);
    	if (count1 == 0) return new ResponseEntity<>("Product not found for this id: " + productId, HttpStatus.OK);
		
		Product product = productRepository.getById(productId);
		CreateProductDTO info = new CreateProductDTO();
		
		info.setProductName(product.getProductName());
		info.setPrice(product.getPrice());
		info.setQuantity(product.getQuantity());
		info.setImage(product.getImage());
		info.setDescription(product.getDescription());
		info.setMaterial(product.getMaterial());
		info.setDimension(product.getDimension());
		
		List<Color> colors = colorRepository.productColor(productId);
		List<Category> categories = categoryRepository.productCategory(productId);
		
		Set<Long> colorIds = new HashSet<Long>();
		Set<Long> categoryIds = new HashSet<Long>();
		
		for (Color color : colors) {
			colorIds.add(color.getColorId());
		}
		
		for (Category category : categories) {
			categoryIds.add(category.getCategoryId());
		}
		
		info.setColorIds(colorIds);
		info.setCategoryIds(categoryIds);
		
		return new ResponseEntity<CreateProductDTO>(info, HttpStatus.OK);
	}
	
	//STAFF - Edit a Product
	@PostMapping("/editproduct/{id}")
	public ResponseEntity<?> editProduct(@PathVariable(value = "id") Long productId, @RequestBody CreateProductDTO product){
		productRepository.editProductInfo(product.getProductName(), product.getPrice(), product.getQuantity(), product.getImage(), product.getDescription(), product.getMaterial(), product.getDimension(), productId);
		productRepository.deleteProductColor(productId);
		productRepository.deleteProductCategory(productId);
		
		Set<Long> colorIds = product.getColorIds();
		Set<Long> categoryIds = product.getCategoryIds();
		
		for (Long colorId : colorIds) {
			productRepository.insertProductColor(productId, colorId);
		}
		
		for (Long categoryId : categoryIds) {
			productRepository.insertProductCategory(productId, categoryId);
		}
		
		return new ResponseEntity<>("Edit Product Successful", HttpStatus.OK);
	}
	
	//STAFF - Delete a Product
	@RequestMapping("/deleteproduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
		int count1 = productRepository.countExistID(productId);
    	if (count1 == 0) return new ResponseEntity<>("Product not found for this id: " + productId, HttpStatus.OK);
		
		productRepository.deleteProductColor(productId);
		productRepository.deleteProductCategory(productId);
		
		productRepository.deleteById(productId);
		
		return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
	}
	
	//Search Bar in Shop
	@GetMapping("/products/search")
	public ResponseEntity<?> searchProduct(@RequestBody String searchString) {
		List<ProductInformationDTO> searchList = new ArrayList<ProductInformationDTO>();
		String finalString = "%" + searchString + "%";
		List<Product> products = productRepository.searchProduct(finalString);
		
		for (Product product : products) {
			ProductInformationDTO info = new ProductInformationDTO();
			
			info.setProductId(product.getProductId());
			info.setProductName(product.getProductName());
			info.setPrice(product.getPrice());
			info.setQuantity(product.getQuantity());
			info.setImage(product.getImage());
			info.setDescription(product.getDescription());
			info.setBoughtCount(product.getBoughtCount());
			info.setMaterial(product.getMaterial());
			info.setDimension(product.getDimension());
			List<Color> color = colorRepository.productColor(product.getProductId());
			List<String> colorString = new ArrayList<String>();
			for (int i = 0; i < color.size(); i++) {
				colorString.add(color.get(i).getColorName());
			}
			info.setColors(colorString);
			
			List<Category> category = categoryRepository.productCategory(product.getProductId());
			List<String> categoryString = new ArrayList<String>();
			for (int i = 0; i < category.size(); i++) {
				categoryString.add(category.get(i).getCategoryName());
			}
			info.setCategories(categoryString);
			
			searchList.add(info);
		}
		if (searchList.size() == 0) return new ResponseEntity<>("No products found!", HttpStatus.OK);
		return new ResponseEntity<>(searchList, HttpStatus.OK);
	}
	
	
	
	
	///////////////////////////////////////////////////////SORT & FILTER//////////////////////////////////////////////////
	//Filter Products by Room: 1. Bedroom, 2. Dining Room, 3. Home Office, 4. Kid's Bedroom, 5. Living Room
	@GetMapping("/products/category/{id}")
	public ResponseEntity<?> getProductByCategoryId(@PathVariable(value = "id") Long categoryId){
		if (categoryId < 1 || categoryId > 5) return new ResponseEntity<> ("CATEGORY_NOT_FOUND", HttpStatus.OK);
		List<Product> products = productRepository.getProductByCategory(categoryId);
		List<ProductInformationDTO> result = new ArrayList<ProductInformationDTO>();
		
		for (Product product : products) {
			ProductInformationDTO info = new ProductInformationDTO();
			
			info.setProductId(product.getProductId());
			info.setProductName(product.getProductName());
			info.setPrice(product.getPrice());
			info.setQuantity(product.getQuantity());
			info.setImage(product.getImage());
			info.setDescription(product.getDescription());
			info.setBoughtCount(product.getBoughtCount());
			info.setMaterial(product.getMaterial());
			info.setDimension(product.getDimension());
			List<Color> color = colorRepository.productColor(product.getProductId());
			List<String> colorString = new ArrayList<String>();
			for (int i = 0; i < color.size(); i++) {
				colorString.add(color.get(i).getColorName());
			}
			info.setColors(colorString);
			
			List<Category> category = categoryRepository.productCategory(product.getProductId());
			List<String> categoryString = new ArrayList<String>();
			for (int i = 0; i < category.size(); i++) {
				categoryString.add(category.get(i).getCategoryName());
			}
			info.setCategories(categoryString);
			
			result.add(info);
		}

		return ResponseEntity.ok().body(result);
	}
	
	//Filter Products by Room + Sort By SortID: 1. Price Ascending, 2. Price Descending, 3. Best Sales
	@PostMapping("/products/category/{id}")
	public ResponseEntity<?> getProductByCategoryIdAndSort(@PathVariable(value = "id") Long categoryId, @RequestBody int sortId){
		if (categoryId < 1 || categoryId > 5) return new ResponseEntity<> ("CATEGORY_NOT_FOUND", HttpStatus.OK);
		if (sortId < 1 || sortId > 3) return new ResponseEntity<> ("SORT_NOT_FOUND", HttpStatus.OK);
		
		List<Product> products = new ArrayList<Product>();
		if (sortId == 1) products = productRepository.sortByPriceAsc(categoryId);
		else if (sortId == 2) products = productRepository.sortByPriceDesc(categoryId);
		else products = productRepository.sortByBestSales(categoryId);
		
		List<ProductInformationDTO> result = new ArrayList<ProductInformationDTO>();
			
		for (Product product : products) {
			ProductInformationDTO info = new ProductInformationDTO();
			
			info.setProductId(product.getProductId());
			info.setProductName(product.getProductName());
			info.setPrice(product.getPrice());
			info.setQuantity(product.getQuantity());
			info.setImage(product.getImage());
			info.setDescription(product.getDescription());
			info.setBoughtCount(product.getBoughtCount());
			info.setMaterial(product.getMaterial());
			info.setDimension(product.getDimension());
			List<Color> color = colorRepository.productColor(product.getProductId());
			List<String> colorString = new ArrayList<String>();
			for (int i = 0; i < color.size(); i++) {
				colorString.add(color.get(i).getColorName());
			}
			info.setColors(colorString);
			
			List<Category> category = categoryRepository.productCategory(product.getProductId());
			List<String> categoryString = new ArrayList<String>();
			for (int i = 0; i < category.size(); i++) {
				categoryString.add(category.get(i).getCategoryName());
			}
			info.setCategories(categoryString);
			
			result.add(info);
		}
			return ResponseEntity.ok().body(result);
	}
	
	//Filter Products By Color ONLY IN ALL PRODUCTS PAGE: 1. Black, 2. Pink, 3. Yellow / Orange, 4. Blue, 5. Green, 6. Grey, 7. White, 8. Brown, 
	//9. Natural, 10. Metallic
	@PostMapping("/products")
	public ResponseEntity<?> filterProductsByColor(@RequestBody int filterId) {
		if (filterId < 1 || filterId > 10) return new ResponseEntity<> ("FILTER_NOT_FOUND", HttpStatus.OK);
		
		List<Product> products = new ArrayList<Product>();
		if (filterId == 1) products = productRepository.filterBlack();
		else if (filterId == 2) products = productRepository.filterPink();
		else if (filterId == 3) products = productRepository.filterYellowOrange();
		else if (filterId == 4) products = productRepository.filterBlue();
		else if (filterId == 5) products = productRepository.filterGreen();
		else if (filterId == 6) products = productRepository.filterGrey();
		else if (filterId == 7) products = productRepository.filterWhite();
		else if (filterId == 8) products = productRepository.filterBrown();
		else if (filterId == 9) products = productRepository.filterNatural();
		else products = productRepository.filterMetallic();
		
		List<ProductInformationDTO> finalList = new ArrayList<ProductInformationDTO>();
			
		for (Product product : products) {
			ProductInformationDTO info = new ProductInformationDTO();
				
			info.setProductId(product.getProductId());
			info.setProductName(product.getProductName());
			info.setPrice(product.getPrice());
			info.setQuantity(product.getQuantity());
			info.setImage(product.getImage());
			info.setDescription(product.getDescription());
			info.setBoughtCount(product.getBoughtCount());
			info.setMaterial(product.getMaterial());
			info.setDimension(product.getDimension());
			List<Color> color = colorRepository.productColor(product.getProductId());
			List<String> colorString = new ArrayList<String>();
			for (int i = 0; i < color.size(); i++) {
				colorString.add(color.get(i).getColorName());
			}
			info.setColors(colorString);
			
			List<Category> category = categoryRepository.productCategory(product.getProductId());
			List<String> categoryString = new ArrayList<String>();
			for (int i = 0; i < category.size(); i++) {
				categoryString.add(category.get(i).getCategoryName());
			}
			info.setCategories(categoryString);
			
			finalList.add(info);			
		}
			
		return new ResponseEntity<List<ProductInformationDTO>>(finalList, HttpStatus.OK);
	}

}
