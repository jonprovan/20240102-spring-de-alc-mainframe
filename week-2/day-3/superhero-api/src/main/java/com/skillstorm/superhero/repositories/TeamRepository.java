package com.skillstorm.superhero.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

}
