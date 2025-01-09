package com.skillstorm.superhero.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Universe() {
		super();
	}

	public Universe(int universeId, String universeName, int universeFounded) {
		super();
		this.universeId = universeId;
		this.universeName = universeName;
		this.universeFounded = universeFounded;
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

	@Override
	public String toString() {
		return "Universe [universeId=" + universeId + ", universeName=" + universeName + ", universeFounded="
				+ universeFounded + "]";
	}

}
