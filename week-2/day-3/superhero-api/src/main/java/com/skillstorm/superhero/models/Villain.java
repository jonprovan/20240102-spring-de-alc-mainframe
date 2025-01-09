package com.skillstorm.superhero.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "origin_id")
	private int originId;
	
	@Column(name = "team_id")
	private int teamId;
	
	@Column(name = "universe_id")
	private int universeId;

	public Villain() {
		super();
	}

	public Villain(int villainId, String villainStageName, String villainRealName, int villainAge, int originId,
			int teamId, int universeId) {
		super();
		this.villainId = villainId;
		this.villainStageName = villainStageName;
		this.villainRealName = villainRealName;
		this.villainAge = villainAge;
		this.originId = originId;
		this.teamId = teamId;
		this.universeId = universeId;
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

	public int getOriginId() {
		return originId;
	}

	public void setOriginId(int originId) {
		this.originId = originId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getUniverseId() {
		return universeId;
	}

	public void setUniverseId(int universeId) {
		this.universeId = universeId;
	}

	@Override
	public String toString() {
		return "Villain [villainId=" + villainId + ", villainStageName=" + villainStageName + ", villainRealName="
				+ villainRealName + ", villainAge=" + villainAge + ", originId=" + originId + ", teamId=" + teamId
				+ ", universeId=" + universeId + "]";
	}

}
