package com.skillstorm.superhero.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	// the other side of our ManyToOne will be OneToMany here
	@OneToMany(mappedBy = "team")
	@JsonIgnoreProperties("team")
	private List<Villain> villains;

	public Team() {
		super();
	}

	public Team(int teamId, String teamName, String teamEstablished, List<Villain> villains) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamEstablished = teamEstablished;
		this.villains = villains;
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

	public List<Villain> getVillains() {
		return villains;
	}

	public void setVillains(List<Villain> villains) {
		this.villains = villains;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamEstablished=" + teamEstablished
				+ ", villains=" + villains + "]";
	}

}
