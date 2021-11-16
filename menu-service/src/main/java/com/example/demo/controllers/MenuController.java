package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

	
	
	@GetMapping(path = "/menu/{type}")
	public String getMenu(@PathVariable("type") String type) {
		
		if(type.equalsIgnoreCase("south")) {
		return "Idly,Pongal,Vadai,Othappam";
		} else {
			return "Poha,Parantha,pav bajji,dhokla";

		}
	}
}
