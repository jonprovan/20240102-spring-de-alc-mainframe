package com.skillstorm.superhero.dtos;

public class TeamDTO {
	
	private String teamName;
	private String teamEstablished;
	
	public TeamDTO(String teamName, String teamEstablished) {
		super();
		this.teamName = teamName;
		this.teamEstablished = teamEstablished;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamEstablished() {
		return teamEstablished;
	}
	
	public void setTeamEstablished(String teamEstablished) {
		this.teamEstablished = teamEstablished;
	}

	@Override
	public String toString() {
		return "TeamDTO [teamName=" + teamName + ", teamEstablished=" + teamEstablished + "]";
	}

}
