package com.skillstorm.superhero.dtos;

import com.skillstorm.superhero.models.Origin;
import com.skillstorm.superhero.models.Team;
import com.skillstorm.superhero.models.Universe;
import com.skillstorm.superhero.models.Villain;

public class HeroDTO {
	
	private String heroStageName;
	private String heroRealName;
	private int heroAge;
	private Villain archrival;
	private Origin origin;
	private Team team;
	private Universe universe;
	
	public HeroDTO(String heroStageName, String heroRealName, int heroAge, Villain archrival, Origin origin, Team team,
			Universe universe) {
		super();
		this.heroStageName = heroStageName;
		this.heroRealName = heroRealName;
		this.heroAge = heroAge;
		this.archrival = archrival;
		this.origin = origin;
		this.team = team;
		this.universe = universe;
	}

	public String getHeroStageName() {
		return heroStageName;
	}

	public void setHeroStageName(String heroStageName) {
		this.heroStageName = heroStageName;
	}

	public String getHeroRealName() {
		return heroRealName;
	}

	public void setHeroRealName(String heroRealName) {
		this.heroRealName = heroRealName;
	}

	public int getHeroAge() {
		return heroAge;
	}

	public void setHeroAge(int heroAge) {
		this.heroAge = heroAge;
	}

	public Villain getArchrival() {
		return archrival;
	}

	public void setArchrival(Villain archrival) {
		this.archrival = archrival;
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
		return "HeroDTO [heroStageName=" + heroStageName + ", heroRealName=" + heroRealName + ", heroAge=" + heroAge
				+ ", archrival=" + archrival + ", origin=" + origin + ", team=" + team + ", universe=" + universe + "]";
	}
	
}
