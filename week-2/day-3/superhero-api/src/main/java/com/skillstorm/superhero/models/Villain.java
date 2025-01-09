package com.skillstorm.superhero.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	// for our many-to-many relationship with Power, we can control the relationship from either side
	// we have to specify the join table as well as the columns associated with the foreign keys, etc.
	// for the JoinTable annotation, name is the name of the join table
	// joinColumns specifies the column(s) in the join table that refer(s) to this side (the controlling side)
	// inverseJoinColumns specifies the column(s) in the join table that refer(s) to the other side
	// the controlling side will have all this information; the other side will have much less
	@ManyToMany
	@JoinTable(name = "villain_power",
			   joinColumns = @JoinColumn(name = "villain_id"),
			   inverseJoinColumns = @JoinColumn(name = "power_id"))
	@JsonIgnoreProperties("villains")
	private List<Power> powers;

	public Villain() {
		super();
	}

	public Villain(int villainId, String villainStageName, String villainRealName, int villainAge, Origin origin,
			Team team, Universe universe, List<Power> powers) {
		super();
		this.villainId = villainId;
		this.villainStageName = villainStageName;
		this.villainRealName = villainRealName;
		this.villainAge = villainAge;
		this.origin = origin;
		this.team = team;
		this.universe = universe;
		this.powers = powers;
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

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "Villain [villainId=" + villainId + ", villainStageName=" + villainStageName + ", villainRealName="
				+ villainRealName + ", villainAge=" + villainAge + ", origin=" + origin + ", team=" + team
				+ ", universe=" + universe + ", powers=" + powers + "]";
	}
	
}
