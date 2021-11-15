package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;
import com.example.demo.services.CustomerService;
@RestController
public class CustomerController {

	
	
	
	@Value("${server.port}")
	private String portNumber;
	
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(path = "/api/v1/customers")
	public List<Customer> getCustomerList(){
		
		return this.service.findAll();
	}
	
	
	@GetMapping(path = "/api/v1/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id){
		
		
		
		return this.service.findById(id);
		
	}

	
	
}
