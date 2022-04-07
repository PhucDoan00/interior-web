package doan.backend.dto;

import java.util.List;

import doan.backend.entity.Category;
import doan.backend.entity.Color;
import lombok.Data;

@Data
public class ColorsAndCategoriesDTO {

	private List<Color> colors;
	private List<Category> categories;
	
	public ColorsAndCategoriesDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Color> getColors() {
		return colors;
	}
	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
