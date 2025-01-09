package com.skillstorm.superhero.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Power;

@Repository
public interface PowerRepository extends CrudRepository<Power, Integer> {

}
