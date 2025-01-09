package com.skillstorm.superhero.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "power")
public class Power {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "power_id")
	private int powerId;
	
	@Column(name = "power_name")
	private String powerName;
	
	@ManyToMany(mappedBy = "powers")
	@JsonIgnoreProperties("powers")
	private List<Villain> villains;
	
	@ManyToMany(mappedBy = "powers")
	@JsonIgnoreProperties("powers")
	private List<Hero> heroes;

	public Power() {
		super();
	}

	public Power(int powerId, String powerName, List<Villain> villains, List<Hero> heroes) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
		this.villains = villains;
		this.heroes = heroes;
	}

	public int getPowerId() {
		return powerId;
	}

	public void setPowerId(int powerId) {
		this.powerId = powerId;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public List<Villain> getVillains() {
		return villains;
	}

	public void setVillains(List<Villain> villains) {
		this.villains = villains;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + ", villains=" + villains + ", heroes="
				+ heroes + "]";
	}

}
