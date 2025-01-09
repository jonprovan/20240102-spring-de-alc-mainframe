package com.skillstorm.superhero.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.superhero.models.Hero;

import jakarta.transaction.Transactional;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM hero WHERE hero_id = ?1;", nativeQuery = true)
	void forceDelete(int heroId);

}
