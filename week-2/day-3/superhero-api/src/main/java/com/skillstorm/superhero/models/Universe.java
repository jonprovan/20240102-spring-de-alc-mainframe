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
@Table(name = "universe")
public class Universe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "universe_id")
	private int universeId;
	
	@Column(name = "universe_name")
	private String universeName;
	
	@Column(name = "universe_founded")
	private int universeFounded;
	
	@OneToMany(mappedBy = "universe")
	@JsonIgnoreProperties("universe")
	private List<Villain> villains;

	public Universe() {
		super();
	}

	public Universe(int universeId, String universeName, int universeFounded, List<Villain> villains) {
		super();
		this.universeId = universeId;
		this.universeName = universeName;
		this.universeFounded = universeFounded;
		this.villains = villains;
	}

	public int getUniverseId() {
		return universeId;
	}

	public void setUniverseId(int universeId) {
		this.universeId = universeId;
	}

	public String getUniverseName() {
		return universeName;
	}

	public void setUniverseName(String universeName) {
		this.universeName = universeName;
	}

	public int getUniverseFounded() {
		return universeFounded;
	}

	public void setUniverseFounded(int universeFounded) {
		this.universeFounded = universeFounded;
	}

	public List<Villain> getVillains() {
		return villains;
	}

	public void setVillains(List<Villain> villains) {
		this.villains = villains;
	}

	@Override
	public String toString() {
		return "Universe [universeId=" + universeId + ", universeName=" + universeName + ", universeFounded="
				+ universeFounded + ", villains=" + villains + "]";
	}

}
