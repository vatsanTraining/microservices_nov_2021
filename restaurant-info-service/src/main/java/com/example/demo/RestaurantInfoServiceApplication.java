package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.ifaces.RestaurantInfoRepository;
import com.example.demo.model.RestaurantInfo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Restaurant Information Service",version = "1.0"))
public class RestaurantInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantInfoServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			RestaurantInfoRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new RestaurantInfo("veg-100","Sangeetha","chennai",9894949L));
			}
		};
	}
}
