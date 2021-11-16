package com.example.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.PaymentRepository;
import com.example.demo.model.*;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class PaymentService {

	
	
	private  PaymentRepository repo;

	
	
	public List<Payment> findAll(){
		
		log.debug("Find all method in Service called");
		
		return this.repo.findAll();
	}
	
	public Payment add(Payment entity) {
		
		log.debug("Add Restaurant Method in service called");
		
		return this.repo.save(entity);
	}
	
	public Payment findById(int id) {
	
		   log.debug("Find By Id in Service  Called");
		    
		   
		   return this.repo.findById(id)
				   .orElseThrow( () -> new RuntimeException("Element with Given Id Not found"));
		   
	}
	
	public Payment findByName(String custRef) {
		
		   log.debug("Find By Customer Ref in Service  Called");
		    
		   
		   return this.repo.findByCustomerRef(custRef);
		   
	}

	
	}
