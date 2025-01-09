package com.skillstorm.superhero.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	// this property is NOT in the database, but we need it in order to link back to the villain who has this origin
	// since the relationship is controlled by the other side
	// we tell this property which property on the controlling side maps it
	@OneToOne(mappedBy = "origin")
	// we can remove this property completely from the JSON output
//	@JsonIgnore
	// OR, we can limit how much of it we see by ignoring certain properties
	@JsonIgnoreProperties("origin")
	private Villain villain;

	public Origin() {
		super();
	}

	public Origin(int originId, String originStory, Villain villain) {
		super();
		this.originId = originId;
		this.originStory = originStory;
		this.villain = villain;
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

	public Villain getVillain() {
		return villain;
	}

	public void setVillain(Villain villain) {
		this.villain = villain;
	}

	@Override
	public String toString() {
		return "Origin [originId=" + originId + ", originStory=" + originStory + ", villain=" + villain + "]";
	}
	
}
