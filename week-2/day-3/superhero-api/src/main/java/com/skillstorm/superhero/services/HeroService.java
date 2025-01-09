package com.skillstorm.superhero.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.HeroDTO;
import com.skillstorm.superhero.models.Hero;
import com.skillstorm.superhero.repositories.HeroRepository;

@Service
public class HeroService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private HeroRepository repo;

	public HeroService(HeroRepository repo) {
		super();
		this.repo = repo;
	}
	
	// get
	public ResponseEntity<Iterable<Hero>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(repo.findAll());
	}
	
	// get by ID
	public ResponseEntity<Hero> findById(int heroId) {
		if (repo.existsById(heroId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(heroId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
	}
	
	// create one
	public ResponseEntity<Hero> addOne(HeroDTO heroDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Hero(0, 
								 					  heroDTO.getHeroStageName(), 
								 					  heroDTO.getHeroRealName(), 
								 					  heroDTO.getHeroAge(),
								 					  heroDTO.getArchrival(),
								 					  heroDTO.getOrigin(),
								 					  heroDTO.getTeam(),
								 					  heroDTO.getUniverse(),
								 					  null)));
	}
	
	// update one
	public ResponseEntity<Hero> updateOne(int heroId, HeroDTO heroDTO) {
		if (repo.existsById(heroId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.save(new Hero(heroId, 
										 				  heroDTO.getHeroStageName(), 
										 				  heroDTO.getHeroRealName(), 
										 				  heroDTO.getHeroAge(),
										 				  heroDTO.getArchrival(),
										 				  heroDTO.getOrigin(),
										 				  heroDTO.getTeam(),
										 				  heroDTO.getUniverse(),
										 				  null)));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteOne(int heroId) {
		repo.forceDelete(heroId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}

}