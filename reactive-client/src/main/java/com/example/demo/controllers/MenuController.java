package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class MenuController {

	@Autowired
	@Qualifier("client2")
	private WebClient client;
	
	
	@GetMapping(path = "/client/menu")
	public Mono<String> getAllCustomers(){
	
		
		return client
				 .get()
				  .uri("http://localhost:6060/menu/south")
				  .headers( h -> h.setBasicAuth("india","india"))
				   .retrieve()
				     .bodyToMono(String.class);
			
	}
}
