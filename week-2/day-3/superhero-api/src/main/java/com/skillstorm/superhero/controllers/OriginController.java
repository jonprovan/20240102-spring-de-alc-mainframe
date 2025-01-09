package com.skillstorm.superhero.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.superhero.dtos.OriginDTO;
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
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OriginService service;
	
	// this maps a GET request using this suffix to this method
	@GetMapping
	public Iterable<Origin> findAll(@RequestParam(name = "startsWith", required = false) String startsWith) {
//		logger.debug("******* Controller Log *******");
		
		return service.findAll(startsWith);
	}
	
	// find by ID
	
	// we're now specifying an additional suffix after the "/origin" above
	// path variables in the URL are notated with {}
	// the annotation in the parameter list identifies which of the path variables ({}) go with which local variables
	// @PathVariable("name of path variable from the GetMapping annotation") <variable type> <local variable name>
	// if your path variable name and local variable name match, you don't need the ("path variable name") part
	
	// we're returning a ResponseEntity so we can manage the status code depending on whether or not an Origin was found
	// you type it with whatever it'll contain
	@GetMapping("/{originId}")
	public ResponseEntity<Origin> findById(@PathVariable("originId") int originId) {
		return service.findById(originId);
	}
	
	// adding one
	// @RequestBody assigns the body of the request to the following variable
	// we'll have no problem if the JSON is structured to match the type
	@PostMapping
	public ResponseEntity<Origin> addOne(@RequestBody OriginDTO originDTO) {
		return service.addOne(originDTO);
	}
	
	// updating one
	@PutMapping("/{originId}")
	public ResponseEntity<Origin> updateOne(@PathVariable("originId") int originId, @RequestBody OriginDTO originDTO) {
		return service.updateOne(originId, originDTO);
	}
	
	// deleting one
	@DeleteMapping("/{originId}")
	public ResponseEntity<Void> deleteOne(@PathVariable("originId") int originId) {
		return service.deleteOne(originId);
	}
	
	
	
	

}
