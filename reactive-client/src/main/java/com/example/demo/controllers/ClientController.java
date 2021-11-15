package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	
	@Autowired
	private WebClient client;
	
	
	@GetMapping(path = "/client/customers")
	public Mono<String> getAllCustomers(){
		
		return client
				 .get()
				  .uri("lb://CUSTOMER-SERVICE/api/v1/customers")
				   .retrieve()
				     .bodyToMono(String.class);
		
	}
}
