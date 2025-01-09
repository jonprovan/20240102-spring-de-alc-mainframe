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

import com.skillstorm.superhero.dtos.UniverseDTO;
import com.skillstorm.superhero.models.Universe;
import com.skillstorm.superhero.services.UniverseService;

@RestController
@RequestMapping("/universe")
public class UniverseController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private UniverseService service;

	public UniverseController(UniverseService service) {
		super();
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Universe>> findAll() {
		return service.findAll();
	}
	
	// find one by ID
	@GetMapping("/{universeId}")
	public ResponseEntity<Universe> findById(@PathVariable int universeId) {
		return service.findById(universeId);
	}
	
	// add one
	@PostMapping
	public ResponseEntity<Universe> addOne(@RequestBody UniverseDTO universeDTO) {
		return service.addOne(universeDTO);
	}
	
	// update one
	@PutMapping("/{universeId}")
	public ResponseEntity<Universe> updateOne(@PathVariable int universeId, @RequestBody UniverseDTO universeDTO) {
		return service.updateOne(universeId, universeDTO);
	}
	
	// delete one
	@DeleteMapping("/{universeId}")
	public ResponseEntity<Void> deleteOne(@PathVariable int universeId) {
		return service.deleteOne(universeId);
	}
	
}