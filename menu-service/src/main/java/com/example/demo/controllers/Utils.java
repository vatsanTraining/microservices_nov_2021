package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import brave.Tracer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
@NoArgsConstructor
public class Utils {

	@Autowired
	Tracer tracer;
	
	@NewSpan(name = "util service")
	public String getDetials(String type) {
		log.info("Service method called");
		String message ="";
		if(type.equalsIgnoreCase("south")) {
			message= "Idly,Pongal,Vadai,Othappam" +","+message;
			} else {
				message= "Poha,Parantha,pav bajji,dhokla"+","+message;

			}

		log.info("service finished");
		return message;
	}
}
