package com.skillstorm.superhero.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "villain")
public class Villain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "villain_id")
	private int villainId;
	
	@Column(name = "villain_stage_name")
	private String villainStageName;
	
	@Column(name = "villain_real_name")
	private String villainRealName;
	
	@Column(name = "villain_age")
	private int villainAge;
	
	// these three columns are foreign keys to other tables
	// we want to map them to the objects they represent
	// this way, when we make requests, we can get back the related records
	
	// the OneToOne annotation specifies a one-to-one relationship
	// in JoinColumn, name is the column in this table, referencedColumnName is the column in the other table
	// it knows which table to look in from the object type
	
	@OneToOne
	@JoinColumn(name = "origin_id", referencedColumnName = "origin_id")
	@JsonIgnoreProperties("villain")
	private Origin origin;
	
//	@Column(name = "origin_id")
//	private int originId;
	
	// the other two are many-to-one
	// many villains go to one team/universe, so we use ManyToOne here and not OneToMany
	// in the other classes, we'd use OneToMany
	
	@ManyToOne
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	@JsonIgnoreProperties("villains")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "universe_id", referencedColumnName = "universe_id")
	@JsonIgnoreProperties("villains")
	private Universe universe;
	
//	@Column(name = "team_id")
//	private int teamId;
//	
//	@Column(name = "universe_id")
//	private int universeId;

	public Villain() {
		super();
	}

	public Villain(int villainId, String villainStageName, String villainRealName, int villainAge, Origin origin, Team team,
			Universe universe) {
		super();
		this.villainId = villainId;
		this.villainStageName = villainStageName;
		this.villainRealName = villainRealName;
		this.villainAge = villainAge;
		this.origin = origin;
		this.team = team;
		this.universe = universe;
	}

	public int getVillainId() {
		return villainId;
	}

	public void setVillainId(int villainId) {
		this.villainId = villainId;
	}

	public String getVillainStageName() {
		return villainStageName;
	}

	public void setVillainStageName(String villainStageName) {
		this.villainStageName = villainStageName;
	}

	public String getVillainRealName() {
		return villainRealName;
	}

	public void setVillainRealName(String villainRealName) {
		this.villainRealName = villainRealName;
	}

	public int getVillainAge() {
		return villainAge;
	}

	public void setVillainAge(int villainAge) {
		this.villainAge = villainAge;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	@Override
	public String toString() {
		return "Villain [villainId=" + villainId + ", villainStageName=" + villainStageName + ", villainRealName="
				+ villainRealName + ", villainAge=" + villainAge + ", origin=" + origin + ", team=" + team
				+ ", universe=" + universe + "]";
	}
	
}
