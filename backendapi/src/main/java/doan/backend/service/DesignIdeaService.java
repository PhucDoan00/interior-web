package doan.backend.service;

import java.util.List;

import doan.backend.dto.DesignIdeaItemsDTO;
import doan.backend.dto.ProductInformationDTO;

public interface DesignIdeaService {

	List<DesignIdeaItemsDTO> getDesignIdeaList(long categoryId, long styleId);
	
	List<ProductInformationDTO> getDesignIdeaItems(long ideaId);
	
	String[] livingroomDescription();
	
	String[] bedroomDescription();
}
