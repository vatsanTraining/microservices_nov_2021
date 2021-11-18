package com.example.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.ifaces.RestaurantInfoRepository;
import com.example.demo.model.*;
import java.util.*;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Data
@Slf4j
public class RestaurantInfoService {

	
	private  RestaurantInfoRepository repo;

	public RestaurantInfoService(RestaurantInfoRepository repo) {
		super();
		this.repo = repo;
		log.info("Restaurant Service Initialized");
	}
	
	
	public List<RestaurantInfo> findAll(){
		
		log.info("Find all method in Service called");
		
		return this.repo.findAll();
	}
	
	public RestaurantInfo add(RestaurantInfo entity) {
		
		log.info("Add Restaurant Method in service called");
		
		return this.repo.save(entity);
	}
	
	public RestaurantInfo findById(String id) {
	
		   log.info("Find By Id in Service  Called");
		    
		   
		   return this.repo.findById(id)
				   .orElseThrow( () -> new ElementNotFoundException("Element with Given Id Not found"));
		   
	}
	
	public Optional<String> remove(String id) {
		
		
		   Optional<String> optional = Optional.empty();

		   if(this.repo.existsById(id)) {

		   this.repo.deleteById(id);

		   optional = Optional.of(id);
		   }

		         return optional;  
	
		
	}
	
	public RestaurantInfo update(RestaurantInfo entity) {
		
		// save method works like a upsert if there is an record with the id is present it updates it
		// else it inserts a new record
		
		return this.repo.save(entity);
	}
	
	public List<RestaurantInfo> findByLocation(String location){
		
		return this.repo.findByLocation(location);
	}
	
	public List<RestaurantInfo> findRestaurantByName(String srchString){
		
		return this.repo.findByName(srchString);
	}
	
	public int updatePhoneNumber(long latestPhoneNumber,String id) {
		
		return this.repo.updatePhoneNumber(latestPhoneNumber, id);
	}
}
