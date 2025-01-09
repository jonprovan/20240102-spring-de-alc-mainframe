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

import com.skillstorm.superhero.dtos.HeroDTO;
import com.skillstorm.superhero.models.Hero;
import com.skillstorm.superhero.services.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private HeroService service;

	public HeroController(HeroService service) {
		super();
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Hero>> findAll() {
		return service.findAll();
	}
	
	// find one by ID
	@GetMapping("/{heroId}")
	public ResponseEntity<Hero> findById(@PathVariable int heroId) {
		return service.findById(heroId);
	}
	
	// add one
	@PostMapping
	public ResponseEntity<Hero> addOne(@RequestBody HeroDTO heroDTO) {
		return service.addOne(heroDTO);
	}
	
	// update one
	@PutMapping("/{heroId}")
	public ResponseEntity<Hero> updateOne(@PathVariable int heroId, @RequestBody HeroDTO heroDTO) {
		return service.updateOne(heroId, heroDTO);
	}
	
	// delete one
	@DeleteMapping("/{heroId}")
	public ResponseEntity<Void> deleteOne(@PathVariable int heroId) {
		return service.deleteOne(heroId);
	}
	
}