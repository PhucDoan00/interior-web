package doan.flamebackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import doan.flamebackend.entity.DesignIdea;

@Service
public interface DesignIdeaService {

	DesignIdea getDesignIdeaById(Long ideaId);

	List<DesignIdea> getAllIdeas();

}
