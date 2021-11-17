package com.example.demo.controllers;

import java.security.Principal;
import java.time.LocalDate;

import javax.annotation.security.RolesAllowed;
import java.util.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
	@RolesAllowed(value = "{ROLE_ADMIN}")
	@PreAuthorize("#oauth2.hasScope('read')")
	public Payment getPaymentDetails(@PathVariable("custName") String custName ,
			 Principal principal) {
		
		OAuth2Authentication oAuth = (OAuth2Authentication) principal;
		
		System.out.println(oAuth.getPrincipal());
		System.out.println(oAuth.getName());
		
//		 Map<String, Object> details = (Map<String, Object>)oAuth.getUserAuthentication().getDetails();
//
//		       Set<Map.Entry<String,Object>> set =  details.entrySet();
//
//		       for(Map.Entry<String, Object> eachEntry:set) {
//		    	   System.out.println(eachEntry.getKey());
//		    	   System.out.println(eachEntry.getValue());
//		       }
		       
		return service.findByName(custName);
	}
	

	
	
}
