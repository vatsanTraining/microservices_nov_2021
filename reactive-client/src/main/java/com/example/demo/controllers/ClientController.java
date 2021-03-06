package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.CustomerDTO;

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
	
	@GetMapping(path = "/client/srch/customers")
	public Mono<CustomerDTO[]> getAllCustomersAsObect(){
		
		return client
				 .get()
				  .uri("lb://CUSTOMER-SERVICE/api/v1/customers")
				   .retrieve()
				     .bodyToMono(CustomerDTO[].class);
		
	}
	
	
	@GetMapping(path = "/client/customers/{id}")
	public Mono<String> getCustomerById(@PathVariable("id") int id){
		
		return client
				 .get()
				  .uri("lb://CUSTOMER-SERVICE/api/v1/customers/"+id)
				   .retrieve()
				     .bodyToMono(String.class);
		
	}
	@GetMapping(path = "/client/srch/customers/{id}")
	public Mono<CustomerDTO> getCustomerByIdAsObject(@PathVariable("id") int id){
		
		return client
				 .get()
				  .uri("lb://CUSTOMER-SERVICE/api/v1/customers/"+id)
				   .retrieve()
				     .bodyToMono(CustomerDTO.class);
		
	}
}
