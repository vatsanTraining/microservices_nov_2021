package com.example.demo.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.services.PaymentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/")
@AllArgsConstructor

public class PaymentController {

	private  PaymentService service;
	
	
	@GetMapping("/payments/{custName}")
	public Payment getPaymentDetails(@PathVariable("custName") String custName ) {
		
		
		return service.findByName(custName);
	}
	

	
	
}
