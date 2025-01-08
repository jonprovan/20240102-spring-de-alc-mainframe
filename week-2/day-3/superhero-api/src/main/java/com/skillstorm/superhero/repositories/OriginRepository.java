package com.skillstorm.superhero.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Origin;

// a Repository provides many pre-fab methods for accessing database entities
// we do not need to code ANY of these ourselves!
// however, if we wish to add custom queries, we can do so here

// we need an annotation here to set this up as an injectable component
// this allows @ComponentScan to find it, and allows us to inject it elsewhere (our service)
@Repository
// we extend an existing type of repo to get certain functionality
// we must type the extension with the model type we want to get as well as the primary key type
public interface OriginRepository extends CrudRepository<Origin, Integer> {
	
	// this is a custom query
	// the value is the actual SQL query, nativeQuery means we can type it in plain SQL syntax
	// we had to get fancy with the SQL wildcard (see the service)
	// for the method stub, we DO NOT need to implement it!
	@Query(value = "SELECT * FROM origin WHERE origin_story LIKE ?1;", nativeQuery = true)
	Iterable<Origin> findAllStartingWith(String startsWith);

}