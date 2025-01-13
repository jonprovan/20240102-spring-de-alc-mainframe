package com.skillstorm.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.api.RestaurantClient;

@RestController
// even though we routed requests with this suffix here, we still have to match the FULL URL with our controller mappings
@RequestMapping("/menu")
public class MenuController {
	
	private Map<Integer, String> menuItems = new HashMap<>();
	
	private RestaurantClient restaurantClient;
	
	public MenuController(RestaurantClient restaurantClient) {
		this.restaurantClient = restaurantClient;
		
		menuItems.put(1, "Fried Chicken");
		menuItems.put(2, "Mandarin Oranges");
		menuItems.put(3, "Spider Rolls");
	}
	
	@GetMapping
	public ResponseEntity<Map<Integer, String>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(menuItems);
	}
	
	// using generic typing for input, but we should really use a DTO
	// we're also responding to the other service's FeignClient request here
	@PostMapping()
	public ResponseEntity<String> getFood(@RequestBody Map<String, Integer> menuItem) {
		return ResponseEntity.status(HttpStatus.OK).body(menuItems.get(menuItem.get("id")));
	}
	
	@GetMapping("/test")
	public String feignTest() {
		return "This message is coming from the Menu Service.";
	}
	
	// using our FeignClient to request the restaurant name that serves the provided food
	@PostMapping("/restaurant")
	public ResponseEntity<String> getAssociatedRestaurant(@RequestBody Map<String, String> menuItem) {
		
		Integer id = 0;
		
		// since we're searching through the map backward (by value), we have to get a little fancy
		for (Integer key : menuItems.keySet())
			if (menuItems.get(key).equals(menuItem.get("name")))
				id = key;
		
		return ResponseEntity.status(HttpStatus.OK).body(this.restaurantClient.getAssociatedRestaurant(id));
	}

}
