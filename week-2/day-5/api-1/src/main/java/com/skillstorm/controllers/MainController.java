package com.skillstorm.controllers;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.models.Message;

@RestController
@RequestMapping("/main")
public class MainController {
	
	// this annotation draws this value from our application.properties file as its default value
	@Value("${api2.user}")
	private String api2user;
	
	@Value("${api2.password}")
	private String api2password;
	
	// we want this method to reach out to our other API and get the messages
	// we use RestTemplate outside of microservices to make calls to other APIs
	// this is a template for making HTTP requests
	// we can use all the different request types, add headers, add bodies, parameters, etc.
	@GetMapping
	public ResponseEntity<Message[]> getAllMessages() {
		
		// instantiate a RestTemplate normally
		RestTemplate rt = new RestTemplate();
		
		// a headers object we'll add to our request
		HttpHeaders headers = new HttpHeaders();
		
		// putting together the value for the Authorization header
		String authString = "Basic " + Base64.getEncoder().encodeToString((api2user + ":" + api2password).getBytes());
		
		// adding the header to our headers object
		headers.add("Authorization", authString);
		
		// we'll need an entity, which represents the request itself (headers and body)
		// originally, we didn't have headers or body, but we still need an empty entity even if that's the case
		// now, we're adding our headers to the outgoing entity, still with no body
		HttpEntity<Object> entity = new HttpEntity<>(headers);
		
		// .exchange() executes the request and returns a response entity
		// we type it with what the body object(s) correspond to in this API
		// the parameters are URL, HTTP method, the built entity (request), and the class type of the return
		ResponseEntity<Message[]> response = rt.exchange("http://localhost:8082/main", HttpMethod.GET, entity, Message[].class);
		
		return response;
		
	}
	
	@PostMapping
	public ResponseEntity<Message> createOne(@RequestBody Message message) {
//		RestTemplate rt = new RestTemplate();
		
//		HttpEntity<Message> entity = new HttpEntity<>(message);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + Base64.getEncoder().encodeToString((api2user + ":" + api2password).getBytes()));
		
		return new RestTemplate().exchange("http://localhost:8082/main", HttpMethod.POST, new HttpEntity<>(message, headers), Message.class);
	}
	
	@GetMapping("/secure")
	public ResponseEntity<Message> returnSecureMessage() {
		return ResponseEntity.status(200).body(new Message("This message is OH SO SECURE YOU GUYZZZZZ"));
	}
	
}