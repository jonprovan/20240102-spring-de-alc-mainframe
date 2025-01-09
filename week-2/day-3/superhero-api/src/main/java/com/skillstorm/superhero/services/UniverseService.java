package com.skillstorm.superhero.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.UniverseDTO;
import com.skillstorm.superhero.models.Universe;
import com.skillstorm.superhero.repositories.UniverseRepository;

@Service
public class UniverseService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private UniverseRepository repo;

	public UniverseService(UniverseRepository repo) {
		super();
		this.repo = repo;
	}
	
	// get
	public ResponseEntity<Iterable<Universe>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(repo.findAll());
	}
	
	// get by ID
	public ResponseEntity<Universe> findById(int universeId) {
		if (repo.existsById(universeId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(universeId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
	}
	
	// create one
	public ResponseEntity<Universe> addOne(UniverseDTO universeDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Universe(0, universeDTO.getUniverseName(), universeDTO.getUniverseFounded())));
	}
	
	// update one
	public ResponseEntity<Universe> updateOne(int universeId, UniverseDTO universeDTO) {
		if (repo.existsById(universeId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.save(new Universe(universeId, universeDTO.getUniverseName(), universeDTO.getUniverseFounded())));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteOne(int universeId) {
		repo.deleteById(universeId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}

}