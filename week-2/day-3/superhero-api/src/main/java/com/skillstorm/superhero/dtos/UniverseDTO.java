package com.skillstorm.superhero.dtos;

public class UniverseDTO {
	
	private String universeName;
	private int universeFounded;
	
	public UniverseDTO(String universeName, int universeFounded) {
		super();
		this.universeName = universeName;
		this.universeFounded = universeFounded;
	}

	public String getUniverseName() {
		return universeName;
	}

	public void setUniverseName(String universeName) {
		this.universeName = universeName;
	}

	public int getUniverseFounded() {
		return universeFounded;
	}

	public void setUniverseFounded(int universeFounded) {
		this.universeFounded = universeFounded;
	}

	@Override
	public String toString() {
		return "UniverseDTO [universeName=" + universeName + ", universeFounded=" + universeFounded + "]";
	}

}
