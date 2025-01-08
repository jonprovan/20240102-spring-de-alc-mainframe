package com.skillstorm.superhero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.superhero.models.Origin;
import com.skillstorm.superhero.services.OriginService;

// this class holds onto various endpoints for this entity and directs them to service methods
// we can specify routing at a base level and per method

// this annotation combines @Controller and @ResponseBody
// @Controller sets this up as a scannable component and a place to look for endpoints
// @ResponseBody wraps up all responses in an HttpReponseBody; otherwise, it might think it should return a webpage
@RestController
// this routes all requests with this suffix here
// methods can tack onto this with additional URL text
@RequestMapping("/origin")
// you may also see CORS filtering here, saying only certain origins can access these endpoints
public class OriginController {
	
	@Autowired
	private OriginService service;
	
	// this maps a GET request using this suffix to this method
	@GetMapping
	public Iterable<Origin> findAll() {
		return service.findAll();
	}
	
	// find by ID
	
	// we're now specifying an additional suffix after the "/origin" above
	// path variables in the URL are notated with {}
	// the annotation in the parameter list identifies which of the path variables ({}) go with which local variables
	// @PathVariable("name of path variable from the GetMapping annotation) <variable type> <local variable name>
	@GetMapping("/{id}")
	public Origin findById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	
	
	

}
