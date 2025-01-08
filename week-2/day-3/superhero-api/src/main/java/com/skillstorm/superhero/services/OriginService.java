package com.skillstorm.superhero.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.OriginDTO;
import com.skillstorm.superhero.models.Origin;
import com.skillstorm.superhero.repositories.OriginRepository;

// this class will include any logic we need to run for our Origin objects, either coming in or going out
// our Controller will reach out to this class before hitting the Repository

// this specifies this class as a service and makes it scannable/injectable, like @Repository
@Service
public class OriginService {
	
	// we have a few ways to inject a dependent object
	// one is with the @Autowired annotation
	
//	@Autowired
//	private OriginRepository repo;
	
	// another is with constructor injection
	// this version is preferred for testing purposes over the @Autowired version
	private OriginRepository repo;
	
	public OriginService(OriginRepository repo) {
		this.repo = repo;
	}
	
	// we can then use the repo methods to take action on our DB
	
	// get all
	public Iterable<Origin> findAll(String startsWith) {
		// if the parameter fed is non-null and not empty, run our custom method
		if (startsWith != null && !startsWith.equals(""))
			// truncating the string to a single character, then tacking on the wildcard
			// it doesn't seem to need the string quotes to be added to the query
			return repo.findAllStartingWith(startsWith.substring(0, 1) + "%");
		else
			// if the parameter is left off, just grab them all!
			return repo.findAll();
	}
	
	// find by ID
	// we return different ResponseEntities based on finding one or not
	public ResponseEntity<Origin> findById(int originId) {
		if (repo.existsById(originId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(originId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
		
		// this does the same thing with only one DB request
		// but the .existsById method is fast, so negligible hit in our case
//		Optional<Origin> origin = repo.findById(id);
//		if (origin.isPresent())
//			return origin.get();
//		else
//			return null;
	}
	
	// creating one
	// by using a DTO and not allowing the user to submit an ID,
	// we avoid having to check if it exists and shrink the amount of data necessary for the GET request
	public ResponseEntity<Origin> addOne(OriginDTO originDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Origin(0, originDTO.getOriginStory())));
	}
	
	// updating one
	// we have to check if it exists first, because if it doesn't, we will create a new one
	public ResponseEntity<Origin> updateOne(int originId, OriginDTO originDTO) {
		if (repo.existsById(originId))
			
			try {
				return ResponseEntity.status(HttpStatus.OK)
						 .body(repo.save(new Origin(originId, originDTO.getOriginStory())));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						 .body(null);
			}
			
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// deleting one
	public ResponseEntity<Void> deleteOne(int originId) {
		repo.deleteById(originId);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}
	
	
	
	

}
