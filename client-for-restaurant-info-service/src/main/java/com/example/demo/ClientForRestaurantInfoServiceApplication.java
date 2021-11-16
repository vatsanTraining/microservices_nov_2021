package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientForRestaurantInfoServiceApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx=	 SpringApplication.run(ClientForRestaurantInfoServiceApplication.class, args);
	
	    RestTemplate template = ctx.getBean(RestTemplate.class);
	    
	    String resp = template.getForObject("http://localhost:8080/api/v1/restaurants", String.class);
	
	    System.out.println(resp);
	    
	    ctx.close();
	}

	@Bean
	public RestTemplate template() {
		
		return new RestTemplate();
	}
}
