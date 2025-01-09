package com.skillstorm.superhero.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "team_name")
	private String teamName;
	
	@Column(name = "team_established")
	private String teamEstablished;

	public Team() {
		super();
	}

	public Team(int teamId, String teamName, String teamEstablished) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamEstablished = teamEstablished;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamEstablished() {
		return teamEstablished;
	}

	public void setTeamEstablished(String teamEstablished) {
		this.teamEstablished = teamEstablished;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamEstablished=" + teamEstablished + "]";
	}

}
