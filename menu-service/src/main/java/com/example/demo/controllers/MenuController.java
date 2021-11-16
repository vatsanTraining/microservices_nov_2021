package com.example.demo.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MenuController {

	
	//@Value("${custom.message}")

	private String message=".";
	
	@GetMapping(path = "/menu/{type}")
	@RolesAllowed(value = {"ROLE_ADMIN","ROLE_USER"})
	public String getMenu(@PathVariable("type") String type,Principal principal) {
		
		System.out.println("user In role :="+principal.getName());
		
		if(type.equalsIgnoreCase("south")) {
		return "Idly,Pongal,Vadai,Othappam" +","+message;
		} else {
			return "Poha,Parantha,pav bajji,dhokla"+","+message;

		}
	}
	
	@GetMapping(path = "/menu/srch/{type}")
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public String getMenuBycuisine(@PathVariable("type") String type,Principal principal) {
		
		System.out.println("user In role :="+principal.getName());
		
		if(type.equalsIgnoreCase("italian")) {
		return "Pizza,Burger" ;
		} else {
			return "pasta,semia";

		}
	}

}
