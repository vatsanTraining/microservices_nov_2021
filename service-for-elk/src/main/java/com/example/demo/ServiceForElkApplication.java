package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RestController
@Slf4j
public class ServiceForElkApplication {

	public static void main(String[] args) {
		
		log.info("main method called");
		SpringApplication.run(ServiceForElkApplication.class, args);
	}

	@GetMapping(path = "/hello")
	public String message() {
		
		log.info("ElK Controller Called");
		return "ELK Example";
	}
}
