package com.skillstorm.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/main")
public class MainController {
	
	private List<Message> messageList = new LinkedList<>();
	
	public MainController() {
		messageList.add(new Message("First 'DB' Message"));
		messageList.add(new Message("Second 'DB' Message"));
		messageList.add(new Message("Third 'DB' Message"));
	}
	
	@GetMapping
	public ResponseEntity<List<Message>> getAllMessages() {
		return ResponseEntity.status(HttpStatus.OK)
							 .body(messageList); 
	}
	
	@PostMapping
	public ResponseEntity<Message> addMessage(@RequestBody Message message) {
		messageList.add(message);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				 .body(messageList.get(messageList.size() - 1)); 
	}
	

}
