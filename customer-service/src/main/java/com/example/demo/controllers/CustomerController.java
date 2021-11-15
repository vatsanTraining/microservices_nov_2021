package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;
@RestController
public class CustomerController {

	
	@Autowired
	private List<Customer> custList;
	
	
	@GetMapping(path = "/api/v1/customers")
	public List<Customer> getCustomerList(){
		
		return this.custList;
	}
}
