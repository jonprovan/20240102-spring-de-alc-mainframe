package com.skillstorm.api;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// this interface will be instantiated via proxy by the application to communicate with our other service
// we need this annotation, and the name must match the name of the service we're calling (no IP/port necessary)
// it will hit the load balancer associated with this service name
// ANY of the service instances with this name could respond
@FeignClient(name = "menu-service")
public interface MenuClient {
	
	// here, this annotation specifies what's GOING OUT, not what's COMING IN
	// so, this one will execute a GET request to the menu-service, using this suffix
	// the annotation on the method in the MenuController should match the type here
	@GetMapping("/menu/test")
	public String getTest();
	
	@PostMapping("/menu")
	public String getAssociatedFood(Map<String, Integer> menuItem);

}
