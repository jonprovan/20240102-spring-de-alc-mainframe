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

import com.skillstorm.superhero.dtos.TeamDTO;
import com.skillstorm.superhero.models.Team;
import com.skillstorm.superhero.services.TeamService;

@RestController
@RequestMapping("/team")
public class VillainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private TeamService service;

	public VillainController(TeamService service) {
		super();
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Team>> findAll() {
		return service.findAll();
	}
	
	// find one by ID
	@GetMapping("/{teamId}")
	public ResponseEntity<Team> findById(@PathVariable int teamId) {
		return service.findById(teamId);
	}
	
	// add one
	@PostMapping
	public ResponseEntity<Team> addOne(@RequestBody TeamDTO teamDTO) {
		return service.addOne(teamDTO);
	}
	
	// update one
	@PutMapping("/{teamId}")
	public ResponseEntity<Team> updateOne(@PathVariable int teamId, @RequestBody TeamDTO teamDTO) {
		return service.updateOne(teamId, teamDTO);
	}
	
	// delete one
	@DeleteMapping("/{teamId}")
	public ResponseEntity<Void> deleteOne(@PathVariable int teamId) {
		return service.deleteOne(teamId);
	}
	
}