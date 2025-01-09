package com.skillstorm.superhero.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.superhero.dtos.TeamDTO;
import com.skillstorm.superhero.models.Team;
import com.skillstorm.superhero.repositories.TeamRepository;

@Service
public class TeamService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private TeamRepository repo;

	public TeamService(TeamRepository repo) {
		super();
		this.repo = repo;
	}
	
	// get
	public ResponseEntity<Iterable<Team>> findAll() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(repo.findAll());
	}
	
	// get by ID
	public ResponseEntity<Team> findById(int teamId) {
		if (repo.existsById(teamId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.findById(teamId).get());
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								 .body(null);
	}
	
	// create one
	public ResponseEntity<Team> addOne(TeamDTO teamDTO) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(repo.save(new Team(0, teamDTO.getTeamName(), teamDTO.getTeamEstablished())));
	}
	
	// update one
	public ResponseEntity<Team> updateOne(int teamId, TeamDTO teamDTO) {
		if (repo.existsById(teamId))
			return ResponseEntity.status(HttpStatus.OK)
								 .body(repo.save(new Team(teamId, teamDTO.getTeamName(), teamDTO.getTeamEstablished())));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								 .body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteOne(int teamId) {
		repo.deleteById(teamId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
							 .body(null);
	}

}