package com.spring.api.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.model.Tutorial;
import com.spring.api.respository.TutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	public List<Tutorial> findAll(){
		return tutorialRepository.findAll();
	}
	
	public Tutorial findById(Long id){
		return tutorialRepository.findById(id).get();
	}

	public boolean isEmptyById(Long id){
		return tutorialRepository.findById(id).isEmpty();
	}
	
	public Tutorial save(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}
	
	public HashMap<String, String> deleteById(Long id) {
		HashMap<String, String> respuesta = new HashMap<>();
		tutorialRepository.deleteById(id);
		respuesta.put("mensaje", "Elemento eliminado correctamente");
		return respuesta;
	}
}
