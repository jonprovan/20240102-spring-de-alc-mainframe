package com.skillstorm.superhero.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.superhero.dtos.VillainDTO;
import com.skillstorm.superhero.models.Villain;
import com.skillstorm.superhero.services.VillainService;

@RestController
@RequestMapping("/villain")
public class VillainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private VillainService service;

	public VillainController(VillainService service) {
		super();
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Villain>> findAll() {
		return service.findAll();
	}
	
	// find one by ID
	@GetMapping("/{teamId}")
	public ResponseEntity<Villain> findById(@PathVariable int villainId) {
		return service.findById(villainId);
	}
	
	// add one
	@PostMapping
	public ResponseEntity<Villain> addOne(@RequestBody VillainDTO villainDTO) {
		return service.addOne(villainDTO);
	}
	
	// update one
	@PutMapping("/{teamId}")
	public ResponseEntity<Villain> updateOne(@PathVariable int villainId, @RequestBody VillainDTO villainDTO) {
		return service.updateOne(villainId, villainDTO);
	}
	
	// delete one
	@DeleteMapping("/{teamId}")
	public ResponseEntity<Void> deleteOne(@PathVariable int villainId) {
		return service.deleteOne(villainId);
	}
	
}