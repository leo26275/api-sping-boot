package com.spring.api.controller;

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

import com.spring.api.model.Tutorial;
import com.spring.api.service.TutorialService;

@RestController
@RequestMapping("api/v1/tutorial")
public class TutorialController {
	
	@Autowired
	private TutorialService tutorialService;
	
	@GetMapping("")
	public ResponseEntity<List<Tutorial>> getAll(){
		List<Tutorial> entities = new ArrayList<>();
		tutorialService.findAll().forEach(entities::add);
		if(entities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(entities, HttpStatus.OK);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial){
		return new ResponseEntity<>(tutorialService.save(tutorial), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tutorial> update(@PathVariable("id") long id, @RequestBody Tutorial tutorial){
		Tutorial newTurorial = tutorialService.findById(id);
		newTurorial.setDescription(tutorial.getDescription());
		newTurorial.setTitle(tutorial.getTitle());
		newTurorial.setPublished(tutorial.getPublished());
		
		return new ResponseEntity<>(tutorialService.save(newTurorial), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id){
		tutorialService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
