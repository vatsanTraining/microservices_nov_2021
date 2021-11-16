package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class MenuServiceClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(MenuServiceClientApplication.class, args);
	
 
	}

	@Bean
	WebClient.Builder builder(){
		
		return WebClient.builder();
	}
	
	@Bean
	WebClient client(WebClient.Builder bldr) {
		
		return bldr.build();
		
	}
}
