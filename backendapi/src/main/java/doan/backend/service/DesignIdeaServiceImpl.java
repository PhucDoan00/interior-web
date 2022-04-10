package doan.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doan.backend.dto.DesignIdeaItemsDTO;
import doan.backend.dto.ProductInformationDTO;
import doan.backend.entity.Category;
import doan.backend.entity.Color;
import doan.backend.entity.DesignIdea;
import doan.backend.entity.Product;
import doan.backend.repository.CategoryRepository;
import doan.backend.repository.ColorRepository;
import doan.backend.repository.DesignIdeaRepository;
import doan.backend.repository.ProductRepository;
import doan.backend.repository.StyleRepository;

@Service
public class DesignIdeaServiceImpl implements DesignIdeaService{

	@Autowired
	DesignIdeaRepository designIdeaRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ColorRepository colorRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	StyleRepository styleRepository;
	
	@Autowired
	DesignIdeaService designIdeaService;
	
	@Override
	public List<ProductInformationDTO> getDesignIdeaItems(long ideaId) {
		Iterable<Object[]> data = designIdeaRepository.getDesignIdeaItems(ideaId);
		ArrayList<ProductInformationDTO> result = new ArrayList<ProductInformationDTO>();
		data.forEach(item -> {
			Product product = productRepository.getOne(item[1] == null ? null : (Integer)item[1]);
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
		);
		return result;
	}
	
	@Override
	public List<DesignIdeaItemsDTO> getDesignIdeaList(long categoryId, long styleId) {
		List<DesignIdea> data = designIdeaRepository.getDesignIdeaList(categoryId, styleId);
		ArrayList<DesignIdeaItemsDTO> result = new ArrayList<DesignIdeaItemsDTO>();
		for (DesignIdea item : data) {
			List<ProductInformationDTO> list = designIdeaService.getDesignIdeaItems(item.getIdeaId());
			DesignIdeaItemsDTO product = new DesignIdeaItemsDTO();
			/*private long designIdeaId;
			private String designIdeaName;
			private String designIdeaDescription;
			private String categoryName;
			private String styleName;
			private String image;
			private List<ProductInformationDTO> itemList;*/
			product.setDesignIdeaId(item.getIdeaId());
			product.setDesignIdeaName(item.getIdeaName());
			product.setDesignIdeaDescription(item.getDescription());
			product.setCategoryName(categoryRepository.getById(categoryId).getCategoryName());
			product.setStyleName(styleRepository.getById(styleId).getStyleName());
			product.setImage(item.getImage());
			product.setItemList(list);
			
			result.add(product);
		}
		return result;
	}
}
