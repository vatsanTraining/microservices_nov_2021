package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	@Autowired
	WebClient client ;
	
	@GetMapping(path = "/client")
	public Mono<String> getAll(){
 return client.get().uri("http://localhost:6060/menu/south")
		        .headers(headers -> headers.setBasicAuth("india","india"))
		        .retrieve()
		              .bodyToMono(String.class);

	}

}
