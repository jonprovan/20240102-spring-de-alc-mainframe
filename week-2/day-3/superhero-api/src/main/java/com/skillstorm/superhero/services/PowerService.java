package com.skillstorm.superhero.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.PowerDTO;
import com.skillstorm.superhero.models.Power;
import com.skillstorm.superhero.repositories.PowerRepository;

@Service
public class PowerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private PowerRepository repo;

	public PowerService(PowerRepository repo) {
		super();
		this.repo = repo;
	}
	
	// get
	public ResponseEntity<Iterable<Power>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(repo.findAll());
	}
	
	// get by ID
	public ResponseEntity<Power> findById(int powerId) {
		if (repo.existsById(powerId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(powerId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
	}
	
	// create one
	public ResponseEntity<Power> addOne(PowerDTO powerDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Power(0, powerDTO.getPowerName(), null, null)));
	}
	
	// update one
	public ResponseEntity<Power> updateOne(int teamId, PowerDTO powerDTO) {
		if (repo.existsById(teamId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.save(new Power(teamId, powerDTO.getPowerName(), null, null)));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteOne(int powerId) {
		repo.deleteById(powerId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}

}