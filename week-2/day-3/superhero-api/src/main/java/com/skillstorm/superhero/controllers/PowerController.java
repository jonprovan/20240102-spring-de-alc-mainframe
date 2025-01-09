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

import com.skillstorm.superhero.dtos.PowerDTO;
import com.skillstorm.superhero.dtos.TeamDTO;
import com.skillstorm.superhero.models.Power;
import com.skillstorm.superhero.models.Team;
import com.skillstorm.superhero.services.PowerService;
import com.skillstorm.superhero.services.TeamService;

@RestController
@RequestMapping("/power")
public class PowerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private PowerService service;

	public PowerController(PowerService service) {
		super();
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Power>> findAll() {
		return service.findAll();
	}
	
	// find one by ID
	@GetMapping("/{powerId}")
	public ResponseEntity<Power> findById(@PathVariable int powerId) {
		return service.findById(powerId);
	}
	
	// add one
	@PostMapping
	public ResponseEntity<Power> addOne(@RequestBody PowerDTO powerDTO) {
		return service.addOne(powerDTO);
	}
	
	// update one
	@PutMapping("/{powerId}")
	public ResponseEntity<Power> updateOne(@PathVariable int powerId, @RequestBody PowerDTO powerDTO) {
		return service.updateOne(powerId, powerDTO);
	}
	
	// delete one
	@DeleteMapping("/{powerId}")
	public ResponseEntity<Void> deleteOne(@PathVariable int powerId) {
		return service.deleteOne(powerId);
	}
	
}