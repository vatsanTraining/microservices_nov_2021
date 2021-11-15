package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;
@RestController
public class CustomerController {

	
	@Autowired
	private List<Customer> custList;
	
	
	@Autowired
	private Customer customer;
	
	
	@Value("${server.port}")
	private String portNumber;
	
	@GetMapping(path = "/api/v1/customers")
	public List<Customer> getCustomerList(){
		
		return this.custList;
	}
	
	
	@GetMapping(path = "/api/v1/customers/{id}")
	public String getCustomerById(@PathVariable("id") int id){
		
		
		
		return this.customer.toString()+this.portNumber;
	}

	
	
}
