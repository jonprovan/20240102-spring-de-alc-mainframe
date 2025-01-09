package com.skillstorm.superhero.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Villain;

@Repository
public interface VillainRepository extends CrudRepository<Villain, Integer> {

}
