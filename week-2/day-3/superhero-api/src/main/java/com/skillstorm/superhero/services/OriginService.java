package com.skillstorm.superhero.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Iterable<Origin> findAll() {
		// just access the local variable repo and call its methods
		return repo.findAll();
	}
	
	// find by ID
	public Origin findById(int id) {
		if (repo.existsById(id))
			return repo.findById(id).get();
		else
			return null;
		
		// this does the same thing with only one DB request
		// but the .existsById method is fast, so negligible hit in our case
//		Optional<Origin> origin = repo.findById(id);
//		if (origin.isPresent())
//			return origin.get();
//		else
//			return null;
	}
	
	
	
	

}
