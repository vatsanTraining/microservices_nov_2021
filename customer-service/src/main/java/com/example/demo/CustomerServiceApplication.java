package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	
	@Bean
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh", "ram@abc.com", 848482);
		
	}
	
	@Bean
	public Customer suresh() {
		
		return new Customer(102,"Suresh", "sur@abc.com", 748477);
		
	}
	
	@Bean
	public Customer magesh() {
		
		return new Customer(103,"Magesh", "mag@abc.com", 64867782);
		
	}
}
