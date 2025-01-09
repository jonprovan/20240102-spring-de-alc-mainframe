package com.skillstorm.superhero.dtos;

// we don't really need IDs coming from the client for POST, so we can limit what our POST method takes in using a DTO
// Data Transfer Object
public class OriginDTO {
	
	private String originStory;

	public OriginDTO(String originStory) {
		super();
		this.originStory = originStory;
	}

	public String getOriginStory() {
		return originStory;
	}

	public void setOriginStory(String originStory) {
		this.originStory = originStory;
	}

	@Override
	public String toString() {
		return "OriginDTO [originStory=" + originStory + "]";
	}

}
