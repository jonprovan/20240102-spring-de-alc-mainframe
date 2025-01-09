package com.skillstorm.superhero.dtos;

import com.skillstorm.superhero.models.Origin;
import com.skillstorm.superhero.models.Team;
import com.skillstorm.superhero.models.Universe;

public class VillainDTO {
	
	private String villainStageName;
	private String villainRealName;
	private int villainAge;
	private Origin origin;
	private Team team;
	private Universe universe;
	
	public VillainDTO(String villainStageName, String villainRealName, int villainAge, Origin origin, Team team,
			Universe universe) {
		super();
		this.villainStageName = villainStageName;
		this.villainRealName = villainRealName;
		this.villainAge = villainAge;
		this.origin = origin;
		this.team = team;
		this.universe = universe;
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
		return "VillainDTO [villainStageName=" + villainStageName + ", villainRealName=" + villainRealName
				+ ", villainAge=" + villainAge + ", origin=" + origin + ", team=" + team + ", universe=" + universe
				+ "]";
	}
	
}
