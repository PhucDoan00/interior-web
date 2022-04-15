package doan.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doan.backend.dto.CreateDesignIdeaDTO;
import doan.backend.dto.DesignIdeaForStaffDTO;
import doan.backend.dto.DesignIdeaItemsDTO;
import doan.backend.dto.DesignIdeaStep3DTO;
import doan.backend.dto.DesignIdeaStep4DTO;
import doan.backend.dto.DesignIdeaThumbnailDTO;
import doan.backend.dto.ProductInformationDTO;
import doan.backend.entity.Category;
import doan.backend.entity.DesignIdea;
import doan.backend.entity.Style;
import doan.backend.exception.ResourceNotFoundException;
import doan.backend.repository.CategoryRepository;
import doan.backend.repository.DesignIdeaRepository;
import doan.backend.repository.StyleRepository;
import doan.backend.service.CategoryService;
import doan.backend.service.DesignIdeaService;

@RestController
@RequestMapping("/api/v1/designidea")
public class DesignIdeaController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	StyleRepository styleRepository;
	
	@Autowired
	DesignIdeaService designIdeaService;
	
	@Autowired
	DesignIdeaRepository designIdeaRepository;
	
	String defaultImageS = "https://img.lovepik.com/photo/50084/8709.jpg_wh860.jpg";
	String defaultImageB = "https://s3.envato.com/files/345403921/06-06-20-1.jpg";
	
	/*String[][] smallthumbnail = new String[6][9];
	String[][] bigthumbnail = new String[6][9];
	String[] bedroom = {"https://i.ibb.co/Y8CtnHW/Modern-Bedroom-Ideas.jpg",
						"https://i.ibb.co/yPYZK5v/Mid-Century-Ideas.jpg",
						"https://i.ibb.co/ZSz6BFS/Rustic-Bedroom-Ideas.jpg",
						"https://i.ibb.co/MZLWyw6/Eclectic-Bedroom-Ideas.jpg",
						"https://i.ibb.co/hVgP41W/Coastal-Bedroom-Ideas.jpg",
						"https://i.ibb.co/JC6XZRn/Industrial-Bedroom-Ideas.jpg",
						"https://i.ibb.co/sWsd2mH/traditional-Bedroom-Ideas.jpg",
						"https://i.ibb.co/ThsCpkR/Glam-Bedroom-Ideas.webp"};
	String[] livingroomsmall = {"https://i.ibb.co/C77WQnB/Modern-Living-Room.png",
								"https://i.ibb.co/GFCrXmz/Mid-Century-Living-Room.png",
								"https://i.ibb.co/fFbNDRz/Rustic-Living-Room.png",
								"https://i.ibb.co/chF6vjZ/Eclectic-Living-Room.png",
								"https://i.ibb.co/5FjCwj5/Coastal-Living-Room.png",
								"https://i.ibb.co/b5TNGbn/Industrial-Living-Room.png",
								"https://i.ibb.co/WH1qdtp/Traditional-Living-Room.png",
								"https://i.ibb.co/c89PRSJ/Glam-Living-Room.png"};
	String[] livingroombig = {"https://i.ibb.co/4YMjP8R/modern.png",
							  "https://i.ibb.co/7JSntm1/midcentury.png",
							  "https://i.ibb.co/KqdSt8S/rustic.png",
							  "https://i.ibb.co/H4QLhDK/eclectic.png",
							  "https://i.ibb.co/K6m7bMp/coastal.png",
							  "https://i.ibb.co/18Nv6rN/industrial.png",
							  "https://i.ibb.co/x5w65w8/traditional.png",
							  "https://i.ibb.co/ykxVhcP/glam.png"};*/
	/*{
		for(int i = 0; i < bedroom.length; i++) smallthumbnail[1][i+1] = bedroom[i];
		for(int i = 0; i < livingroomsmall.length; i++) smallthumbnail[5][i+1] = livingroomsmall[i];
		
		for(int i = 0; i < bedroom.length; i++) bigthumbnail[1][i+1] = bedroom[i];
		for(int i = 0; i < livingroombig.length; i++) bigthumbnail[5][i+1] = livingroombig[i];
	}*/
	
	//View a Room's Styles in Design Idea
	@GetMapping("/{id1}")
	public ResponseEntity<DesignIdeaStep3DTO> getSmallThumbnail(@PathVariable(value = "id1") Long categoryId) {
		Category category = categoryRepository.getById(categoryId);
		String cateName = category.getCategoryName();
		DesignIdeaStep3DTO result = new DesignIdeaStep3DTO();
		result.setCategoryName(cateName);
		String bedroomsmall[] = categoryService.bedroom();
		String livingroomsmall[] = categoryService.livingroomsmall();
		String[][] smallthumbnail = new String[6][9];
		
		String bedroombig[] = categoryService.bedroombig();
		String livingroombig[] = categoryService.livingroombig();
		String[][] bigthumbnail = new String[6][9];
		
		String bedroomDes[] = designIdeaService.bedroomDescription();
		String livingroomDes[] = designIdeaService.livingroomDescription();
		for (int i = 0; i < 8; i++) {
			bigthumbnail[1][i+1] = bedroombig[i];
			bigthumbnail[5][i+1] = livingroombig[i];
			System.out.println(bigthumbnail[1][i+1]);
			System.out.println(bigthumbnail[5][i+1]);
		}
		
		List<DesignIdeaThumbnailDTO> list = new ArrayList<DesignIdeaThumbnailDTO>();
		List<Style> styles = styleRepository.findAll();
		
		if ((categoryId == 1) || (categoryId == 5)) {
			for (int i = 0; i < 8; i++) { 
				if (categoryId == 1) smallthumbnail[categoryId.intValue()][i+1] = bedroomsmall[i];
				else smallthumbnail[categoryId.intValue()][i+1] = livingroomsmall[i];
			}
			
			for (Style style : styles) {
				DesignIdeaThumbnailDTO thumbnail = new DesignIdeaThumbnailDTO();
				thumbnail.setStyleId(style.getStyleId());
				thumbnail.setStyleName(style.getStyleName() + " " + cateName);
				thumbnail.setImage(smallthumbnail[categoryId.intValue()][style.getStyleId().intValue()]);
				thumbnail.setImageBig(bigthumbnail[categoryId.intValue()][style.getStyleId().intValue()]);
				if (categoryId == 5) thumbnail.setDescription(livingroomDes[style.getStyleId().intValue()-1]);
				else thumbnail.setDescription(bedroomDes[style.getStyleId().intValue()-1]);
				list.add(thumbnail);
			}
		} else {
			for (Style style : styles) {
				DesignIdeaThumbnailDTO thumbnail = new DesignIdeaThumbnailDTO();
				thumbnail.setStyleName(style.getStyleName() + " " + cateName);
				thumbnail.setImage(defaultImageS);
				thumbnail.setImageBig(defaultImageB);
				thumbnail.setDescription(style.getStyleName() + " " + cateName);
				list.add(thumbnail);
			}
		}
		
		result.setThumbnailList(list);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//View a List of Design Ideas from Room + Style
	@GetMapping("/{id1}/{id2}")
	public ResponseEntity<DesignIdeaStep4DTO> getDesignIdeas(@PathVariable(value = "id1") Long categoryId, @PathVariable(value = "id2") Long styleId) {
		Category category = categoryRepository.getById(categoryId);
		String cateName = category.getCategoryName();
		DesignIdeaStep4DTO result = new DesignIdeaStep4DTO();
		result.setCategoryName(cateName);
		Style style = styleRepository.getById(styleId);
		String styleName = style.getStyleName();
		result.setStyleName(styleName);
		String bedroombig[] = categoryService.bedroombig();
		String livingroombig[] = categoryService.livingroombig();
		String[][] bigthumbnail = new String[6][9];
		for (int i = 0; i < 8; i++) {
			bigthumbnail[1][i+1] = bedroombig[i];
			bigthumbnail[5][i+1] = livingroombig[i];
			System.out.println(bigthumbnail[1][i+1]);
			System.out.println(bigthumbnail[5][i+1]);
		}
		
		if ((categoryId == 1) || (categoryId == 5)) result.setBigThumbnail(bigthumbnail[categoryId.intValue()][styleId.intValue()]);
		else result.setBigThumbnail(defaultImageB);
		
		List<DesignIdeaItemsDTO> itemList = designIdeaService.getDesignIdeaList(categoryId, styleId);
		result.setItemList(itemList);
		
		String livingroomDes[] = designIdeaService.livingroomDescription();
		String bedroomDes[] = designIdeaService.bedroomDescription();
		if (categoryId == 5) result.setDescription(livingroomDes[styleId.intValue() - 1]);
		else if (categoryId == 1) result.setDescription(bedroomDes[styleId.intValue() - 1]);
		else result.setDescription(style.getStyleName() + " " + cateName);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//View a Design Idea's Details
	@GetMapping("/idea/{id}")
	public ResponseEntity<DesignIdeaItemsDTO> getDesignIdeaItems(@PathVariable(value = "id") Long ideaId) {
		DesignIdeaItemsDTO result = new DesignIdeaItemsDTO();
		List<ProductInformationDTO> itemList = designIdeaService.getDesignIdeaItems(ideaId);
		DesignIdea idea = designIdeaRepository.getById(ideaId);
		
		result.setDesignIdeaId(ideaId);
		result.setDesignIdeaName(idea.getIdeaName());
		result.setDesignIdeaDescription(idea.getDescription());
		result.setCategoryName(categoryRepository.getById(idea.getCategory()).getCategoryName());
		result.setStyleName(styleRepository.getById(idea.getStyle()).getStyleName());
		result.setImage(idea.getImage());
		result.setItemList(itemList);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//STAFF - Create a Design Idea
	@PostMapping("/createidea")
	public ResponseEntity<?> createDesignIdea(@RequestBody CreateDesignIdeaDTO idea) {
		DesignIdea di = new DesignIdea();
		di.setIdeaName(idea.getIdeaName());
		di.setDescription(idea.getDescription());
		di.setCategory(idea.getCategoryId());
		di.setStyle(idea.getStyleId());
		di.setImage(idea.getImage());
		
		designIdeaRepository.save(di);
		
		long ideaId = designIdeaRepository.getNewestIdea().getIdeaId();
		List<Long> productIds = idea.getProductIds();
		
		for (Long id : productIds) {
			designIdeaRepository.insertIdeaItem(ideaId, id);
		}
		
		return new ResponseEntity<> ("Create Successful!", HttpStatus.OK);
	}
	
	//STAFF - Get a Design Idea's Details (Before Edit It)
	@GetMapping("/editidea/{id}")
	public ResponseEntity<?> getDesignIdea(@PathVariable(value = "id") Long ideaId) throws ResourceNotFoundException {
		DesignIdea di = designIdeaRepository.findById(ideaId)
		.orElseThrow(() -> new ResourceNotFoundException("Design Idea not found for this id: " + ideaId));
		
		DesignIdeaForStaffDTO idea = new DesignIdeaForStaffDTO();
		
		idea.setDesignIdeaId(ideaId);
		idea.setDesignIdeaName(di.getIdeaName());
		idea.setDesignIdeaDescription(di.getDescription());
		idea.setCategory(di.getCategory());
		idea.setStyle(di.getStyle());
		idea.setImage(di.getImage());
		
		List<ProductInformationDTO> productList = designIdeaService.getDesignIdeaItems(ideaId);
		List<Long> productIds = new ArrayList<Long>();
		
		for (ProductInformationDTO info : productList) {
			productIds.add(info.getProductId());
		}
		
		idea.setProductIds(productIds);
		return new ResponseEntity<> (idea, HttpStatus.OK);
	}
	
	//STAFF - Edit a Design Idea
	@PutMapping("/editidea/{id}")
	public ResponseEntity<?> editDesignIdea(@RequestBody DesignIdeaForStaffDTO idea, @PathVariable(value = "id") Long ideaId) throws ResourceNotFoundException {
		designIdeaRepository.findById(ideaId)
		.orElseThrow(() -> new ResourceNotFoundException("Design Idea not found for this id: " + ideaId));
		
		designIdeaRepository.updateDesignIdea(idea.getDesignIdeaName(), idea.getDesignIdeaDescription(), idea.getCategory(), idea.getStyle(), idea.getImage(), ideaId);
		designIdeaRepository.deleteIdeaItem(ideaId);
		List<Long> productIds = idea.getProductIds();
		
		for (Long id : productIds) {
			designIdeaRepository.insertIdeaItem(ideaId, id);
		}
		
		return new ResponseEntity<> ("Updated Successful!", HttpStatus.OK);
	}
	
	//STAFF - Delete a Design Idea
	@DeleteMapping("/deleteidea/{id}")
	public ResponseEntity<?> deleteDesignIdea(@PathVariable(value = "id") Long ideaId) throws ResourceNotFoundException {
		designIdeaRepository.findById(ideaId)
		.orElseThrow(() -> new ResourceNotFoundException("Design Idea not found for this id: " + ideaId));
		
		designIdeaRepository.deleteIdeaItem(ideaId);
		designIdeaRepository.deleteById(ideaId);
		
		return new ResponseEntity<> ("Deleted Successful!", HttpStatus.OK);
	}
	
	//STAFF - Get a List of All Rooms in the System (In the Edit Step)
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategories() {
		return new ResponseEntity<List<Category>> (categoryRepository.findAll(), HttpStatus.OK);
	}
	
	//STAFF - Get a List of All Styles in the System (In the Edit Step)
	@GetMapping("/style")
	public ResponseEntity<List<Style>> getAllStyles() {
		return new ResponseEntity<List<Style>> (styleRepository.findAll(), HttpStatus.OK);
	}
}