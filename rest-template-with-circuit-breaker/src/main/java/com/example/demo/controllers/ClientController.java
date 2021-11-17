package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	
	@GetMapping(path = "/client")
	@CircuitBreaker(name = "clientservice", fallbackMethod = "getMessageFallBack")
	public String getMessage() {
		
		return this.template.getForObject("http://localhost:5055/hotels", String.class);
	}
	
	public String getMessageFallBack(Exception e) {
		
		return "Fall Back Message - Default Customer";
		
	}
}
