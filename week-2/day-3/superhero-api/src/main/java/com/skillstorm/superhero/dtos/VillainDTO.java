package com.skillstorm.superhero.dtos;

public class VillainDTO {
	
	private String villainStageName;
	private String villainRealName;
	private int villainAge;
	private int originId;
	private int teamId;
	private int universeId;
	
	public VillainDTO(String villainStageName, String villainRealName, int villainAge, int originId, int teamId, int universeId) {
		super();
		this.villainStageName = villainStageName;
		this.villainRealName = villainRealName;
		this.villainAge = villainAge;
		this.originId = originId;
		this.teamId = teamId;
		this.universeId = universeId;
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
		return "VillainDTO [villainStageName=" + villainStageName + ", villainRealName=" + villainRealName
				+ ", villainAge=" + villainAge + ", originId=" + originId + ", teamId=" + teamId + ", universeId="
				+ universeId + "]";
	}
	
}
