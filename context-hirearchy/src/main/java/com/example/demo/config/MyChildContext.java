package com.example.demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;

@SpringBootApplication
public class MyChildContext {

	
	@Bean(name = "childCustomer")
	public Customer ramesh() {
		
		return new Customer(102,"Child Ramesh",7484848,"cram@abc.com");
		
	}
}
