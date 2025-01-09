package com.skillstorm.superhero.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
@Table(name = "hero")
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hero_id")
	private int heroId;
	
	@Column(name = "hero_stage_name")
	private String heroStageName;
	
	@Column(name = "hero_real_name")
	private String heroRealName;
	
	@Column(name = "hero_age")
	private int heroAge;
	
	@OneToOne
	@JoinColumn(name = "archrival", referencedColumnName = "villain_id")
	@JsonIgnoreProperties("archrival")
	private Villain archrival;
	
	@OneToOne
	@JoinColumn(name = "origin_id", referencedColumnName = "origin_id")
	@JsonIgnoreProperties({"villain", "hero"})
	private Origin origin;
	
	@ManyToOne
	@JoinColumn(name = "team_id", referencedColumnName = "team_id")
	@JsonIgnoreProperties({"villains", "heroes"})
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "universe_id", referencedColumnName = "universe_id")
	@JsonIgnoreProperties({"villains", "heroes"})
	private Universe universe;
	
	@ManyToMany
	@JoinTable(name = "hero_power",
			   joinColumns = @JoinColumn(name = "hero_id"),
			   inverseJoinColumns = @JoinColumn(name = "power_id"))
	@JsonIgnoreProperties({"villains", "heroes"})
	private List<Power> powers;

	public Hero() {
		super();
	}

	public Hero(int heroId, String heroStageName, String heroRealName, int heroAge, Villain archrival, Origin origin,
			Team team, Universe universe, List<Power> powers) {
		super();
		this.heroId = heroId;
		this.heroStageName = heroStageName;
		this.heroRealName = heroRealName;
		this.heroAge = heroAge;
		this.archrival = archrival;
		this.origin = origin;
		this.team = team;
		this.universe = universe;
		this.powers = powers;
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
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

	public List<Power> getPowers() {
		return powers;
	}

	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}

	@Override
	public String toString() {
		return "Hero [heroId=" + heroId + ", heroStageName=" + heroStageName + ", heroRealName=" + heroRealName
				+ ", heroAge=" + heroAge + ", archrival=" + archrival + ", origin=" + origin + ", team=" + team
				+ ", universe=" + universe + ", powers=" + powers + "]";
	}
	
}
