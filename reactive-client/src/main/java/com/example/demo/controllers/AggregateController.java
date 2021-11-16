package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.CustomerDTO;
import com.example.demo.model.PaymentDTO;
import com.example.demo.model.ResponseDto;

import reactor.core.publisher.Mono;

@RestController
public class AggregateController {

	
	@Autowired
	private WebClient client;
	
	@Autowired
	private ResponseDto dto;
	
	@GetMapping(path = "/srch/{id}")
	public Mono<ResponseDto> getDetails(@PathVariable("id") int id){
		

		return client.get()
				 .uri("lb://CUSTOMER-SERVICE",uriBuilder -> uriBuilder.path("/api/v1/customers/{id}")
						 .build(id))
				             .retrieve()
				               .bodyToMono(CustomerDTO.class)
				               .zipWhen(custResp -> client.get()
				            		   .uri("lb://PAYMENT-SERVICE" ,uriBuilder -> uriBuilder.path("/api/v1/payments/{name}")
				            				   .build(custResp.getCustomerName())).retrieve().bodyToMono(PaymentDTO.class), 
				            		   (custResp,payResp) -> {	
				            			   dto.setCustomer(custResp);
				            		   dto.setPayment(payResp);
				            		   return dto;
});
				            		   
	}

}
