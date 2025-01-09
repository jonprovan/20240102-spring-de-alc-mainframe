package com.skillstorm.superhero.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Power() {
		super();
	}

	public Power(int powerId, String powerName) {
		super();
		this.powerId = powerId;
		this.powerName = powerName;
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

	@Override
	public String toString() {
		return "Power [powerId=" + powerId + ", powerName=" + powerName + "]";
	}

}
