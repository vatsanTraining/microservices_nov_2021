package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.services.RestaurantInfoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.model.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping(path = "/api/v1/")
@Slf4j
public class RestaurantInfoController {

	
	
	private RestaurantInfoService service;

	public RestaurantInfoController(RestaurantInfoService service) {
		super();
		this.service = service;
		log.info("Restaurant Controller Initialized");

	}
	
	
	@GetMapping(path = "/restaurants")
	@Operation(description = "Gets the List of all the Restaurants")
	public List<RestaurantInfo> getAll(){
		
		log.info("Restaurant Info Controller Get All Called");

		return this.service.findAll();
	}

	@GetMapping(path = "/restaurants/{id}")
	@ApiResponses(@ApiResponse(responseCode = "404",content = {@Content(mediaType = "application/json")},description = "Restaurant with that id is not present"))
    
	public RestaurantInfo getById(@Parameter(description = "the id of the restaurant", example = "veg-101",required = true) @PathVariable("id") String id){
		
		log.info("Restaurant Info Controller Get By Id Called");

		return this.service.findById(id);
	}

	@PostMapping(path = "/restaurants")
	@Operation(description = "To Add a restaurant")
	@ApiResponses(@ApiResponse(responseCode = "201",description = "new restaurant Added"))
	public ResponseEntity<Object> add(@RequestBody RestaurantInfo entity){
		
		this.service.add(entity);
		
		URI location = ServletUriComponentsBuilder
				      .fromCurrentRequest()
				      .path("/{id}")
				      .buildAndExpand(entity.getId())
				      .toUri();
		
		log.info("Restaurant Controller Add Method Called ");

		return ResponseEntity.created(location).body(entity);
		
	}
	

	@PutMapping(path = "/restaurants")
	public ResponseEntity<Object> update(@RequestBody RestaurantInfo entity){
		
		this.service.update(entity);
		
				log.info("Restaurant Controller Update Method Called ");

		return ResponseEntity.status(HttpStatus.OK).body(entity);
		
	}

	
	@DeleteMapping(path = "/restaurants/{id}")
	public String removeById(@PathVariable("id") String id){
		
		log.info("Restaurant Info Controller Remove By Id Called");

		return this.service.remove(id).orElseThrow(() -> new ElementNotFoundException("Element with Given Id Not Found"));
	}

	
	@GetMapping(path = "/restaurants/srch/location/{location}")
	public List<RestaurantInfo> getByLocation(@PathVariable("location") String location){
		
		return this.service.findByLocation(location);
	}
	
	@GetMapping(path = "/restaurants/srch/name/{name}")
	public List<RestaurantInfo> getByRestaurantName(@PathVariable("name") String srchName){
		
		return this.service.findRestaurantByName(srchName);
	}
	
	
	@PatchMapping(path = "/restaurants/{id}/{latestNumber}")
	public ResponseEntity<String> updatePhoneNumber(@PathVariable("id") String id,@PathVariable("latestNumber") long latestNumber){
		
		
		int count = this.service.updatePhoneNumber(latestNumber, id);
		
		String message = "row Updated:="+count;
		
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	
}
