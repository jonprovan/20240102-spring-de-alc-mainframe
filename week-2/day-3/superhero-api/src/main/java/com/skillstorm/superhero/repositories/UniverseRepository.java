package com.skillstorm.superhero.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Universe;

@Repository
public interface UniverseRepository extends CrudRepository<Universe, Integer> {

}
