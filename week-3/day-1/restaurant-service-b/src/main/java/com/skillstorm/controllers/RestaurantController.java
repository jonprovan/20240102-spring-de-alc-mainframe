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

import com.skillstorm.api.MenuClient;

@RestController
// even though we routed requests with this suffix here, we still have to match the FULL URL with our controller mappings
@RequestMapping("/restaurant")
public class RestaurantController {
	
	private Map<String, Integer> restaurants = new HashMap<>();
	
	// to use our FeignClient, we must inject it here
	private MenuClient menuClient;

	public RestaurantController(MenuClient menuClient) {
		this.menuClient = menuClient;
		
		restaurants.put("Colonel America", 1);
		restaurants.put("Cast Iron Man's Skillet", 2);
		restaurants.put("Black Widow Sushi", 3);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Integer>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(restaurants);
	}
	
	// using generic typing for input, but we should really use a DTO
//	@PostMapping()
//	public ResponseEntity<Integer> getFood(@RequestBody Map<String, String> restaurant) {
//		return ResponseEntity.status(HttpStatus.OK).body(restaurants.get(restaurant.get("name")));
//	}
	
	@PostMapping()
	public ResponseEntity<String> getFood(@RequestBody Map<String, String> restaurant) {
		Map<String, Integer> menuItem = new HashMap<>();
		menuItem.put("id", restaurants.get(restaurant.get("name")));
		
		return ResponseEntity.status(HttpStatus.OK).body(this.menuClient.getAssociatedFood(menuItem));
	}
	
	// using our FeignClient to make a request
	@GetMapping("/feigntest")
	public String feignTest() {
		return menuClient.getTest();
	}
	
	// since we're searching through the map backward (by value), we have to get a little fancy
	@PostMapping("/food")
	public String getAssociatedFood(@RequestBody Integer foodId) {
		for (String key : restaurants.keySet())
			if (restaurants.get(key) == foodId)
				return key;
		return null;
	}
	
	@GetMapping("/instance")
	public String checkInstance() {
		return "Instance B";
	}

}
