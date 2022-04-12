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
	
	@Override
	public String[] livingroomDescription() {
		String[] des = {"Modern design is all about chic furniture and statement pieces. For a modern living room, you'll want to blend sleek elements with comfort. To achieve a livable modern living room, find cozy fabrics and plush rugs, and pair them with striking decor and materials!",
						"A mid-century modern living room layout is characterized by its uncluttered design and clean lines. This iconic style blends comfort with modern design elements and a retro aesthetic. There’s something nostalgic about mid-century modern design—which makes sense since it first came on the scene after WWII",
						"A living room is just that; a space where we live! It's used for a multitude of needs, from TV watching, family game nights, gathering of friends, solo reading afternoons and everything in between. This means a living room needs to be both beautiful and functional. A sofa should be both something you enjoy looking at.For those reasons, we can't think of a cozier style than Rustic.",
						"If a space that is both approachable and informal, globally-inspired and multi-style and highly curated sounds like your cup of tea, than an eclectic living room design may be what you need. Eclectic style is all about mixing elements and covers a wide range of looks from bohemian to more elegant and polished",
						"Whether you have a beach cottage or just want an easy living room reminiscent of the seaside, coastal style design is a beautiful solution. With staples like white linen sofas, natural fibers, and weathered woods, coastal living rooms are nothing short of airy and inviting!",
						"Effortlessly cool. Easy going. Undeniably chic. These are all aspects of an industrial-style living room. Exposed brick, piping, concrete or natural wood floors are structural elements that make Industrial style what it is, but even if your home is anything but Industrial, don't despair; you can still bring this coveted cool look to your home with the right decor and furniture!",
						"Traditional design is classic and elegant. A traditional living room can be both timeless and cozy for the whole family. It all depends on the materials used. However, every traditional living room design does have a discerning color palette, curated artwork and decor, and elegant lighting that makes a statement",
						"A glam living room design is for you if you want your living space to make a show-stopping statement. Glam living rooms tend to be more polished and upscale, and often make a pretty bold statement. They're great for entertaining, with their highly styled and considered approach."};
		return des;
	}
}
