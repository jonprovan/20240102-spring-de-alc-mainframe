package com.skillstorm.superhero.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// this specifies that this class is a DB entity
@Entity
// this says which table in the DB this goes with
@Table(name = "origin")
public class Origin {
	
	// this says this variable is a primary key
	@Id
	// this says the value for this variable will be supplied by the DB
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// this says which column in the table this goes with
	@Column(name = "origin_id")
	private int originId;
	
	@Column(name = "origin_story")
	private String originStory;

	public Origin() {
		super();
	}

	public Origin(int originId, String originStory) {
		super();
		this.originId = originId;
		this.originStory = originStory;
	}

	public int getOriginId() {
		return originId;
	}

	public void setOriginId(int originId) {
		this.originId = originId;
	}

	public String getOriginStory() {
		return originStory;
	}

	public void setOriginStory(String originStory) {
		this.originStory = originStory;
	}

	@Override
	public String toString() {
		return "Origin [originId=" + originId + ", originStory=" + originStory + "]";
	}
	
}
