package com.skillstorm.superhero.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.VillainDTO;
import com.skillstorm.superhero.models.Villain;
import com.skillstorm.superhero.repositories.VillainRepository;

@Service
public class VillainService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private VillainRepository repo;

	public VillainService(VillainRepository repo) {
		super();
		this.repo = repo;
	}
	
	// get
	public ResponseEntity<Iterable<Villain>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(repo.findAll());
	}
	
	// get by ID
	public ResponseEntity<Villain> findById(int villainId) {
		if (repo.existsById(villainId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(villainId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
	}
	
	// create one
	public ResponseEntity<Villain> addOne(VillainDTO villainDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Villain(0, 
									 					 villainDTO.getVillainStageName(), 
									 					 villainDTO.getVillainRealName(), 
									 					 villainDTO.getVillainAge(),
									 					 villainDTO.getOrigin(),
									 					 villainDTO.getTeam(),
									 					 villainDTO.getUniverse(),
									 					 null)));
	}
	
	// update one
	public ResponseEntity<Villain> updateOne(int villainId, VillainDTO villainDTO) {
		if (repo.existsById(villainId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.save(new Villain(villainId, 
										 					 villainDTO.getVillainStageName(), 
										 					 villainDTO.getVillainRealName(), 
										 					 villainDTO.getVillainAge(),
										 					 villainDTO.getOrigin(),
										 					 villainDTO.getTeam(),
										 					 villainDTO.getUniverse(),
										 					 null)));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteOne(int villainId) {
		repo.deleteById(villainId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}

}