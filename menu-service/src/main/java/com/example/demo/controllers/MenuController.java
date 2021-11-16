package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MenuController {

	
	@Value("${custom.message}")
	private String message;
	
	@GetMapping(path = "/menu/{type}")
	public String getMenu(@PathVariable("type") String type) {
		
		if(type.equalsIgnoreCase("south")) {
		return "Idly,Pongal,Vadai,Othappam" +","+message;
		} else {
			return "Poha,Parantha,pav bajji,dhokla"+","+message;

		}
	}
}
