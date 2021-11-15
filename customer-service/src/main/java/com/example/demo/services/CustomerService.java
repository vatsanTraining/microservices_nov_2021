package com.example.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ElementNotFoundException;
import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.model.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class CustomerService {

	
	
	private  CustomerRepository repo;

	
	
	public List<Customer> findAll(){
		
		log.debug("Find all method in Service called");
		
		return this.repo.findAll();
	}
	
	public Customer add(Customer entity) {
		
		log.debug("Add Restaurant Method in service called");
		
		return this.repo.save(entity);
	}
	
	public Customer findById(int id) {
	
		   log.debug("Find By Id in Service  Called");
		    
		   
		   return this.repo.findById(id)
				   .orElseThrow( () -> new ElementNotFoundException("Element with Given Id Not found"));
		   
	}
	
	public Optional<Integer> remove(int id) {
		
		
		   Optional<Integer> optional = Optional.empty();

		   if(this.repo.existsById(id)) {

		   this.repo.deleteById(id);

		   optional = Optional.of(id);
		   }

		         return optional;  
	
		
	}
	
	public Customer update(Customer entity) {
		
		// save method works like a upsert if there is an record with the id is present it updates it
		// else it inserts a new record
		
		return this.repo.save(entity);
	}
	

}
