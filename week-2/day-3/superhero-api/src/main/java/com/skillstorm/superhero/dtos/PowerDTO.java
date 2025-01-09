package com.skillstorm.superhero.dtos;

public class PowerDTO {
	
	private String powerName;
	
	public PowerDTO(String powerName) {
		super();
		this.powerName = powerName;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	@Override
	public String toString() {
		return "PowerDTO [powerName=" + powerName + "]";
	}

}
