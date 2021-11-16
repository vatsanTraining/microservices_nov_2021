package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Address;
import com.example.demo.model.RestaurantInfo;

@SpringBootApplication
public class AutowireProfilesLifecycleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(AutowireProfilesLifecycleApplication.class, args);
		
		System.out.println(ctx.getBean(RestaurantInfo.class));
		
	}

	
	@Bean
	public RestaurantInfo info() {
		
		return new RestaurantInfo("AB1010", "Sangeetha", "chennai", 9484822L);
	}
	
	@Bean
	public Address billingAddress() {
		
		
		return new Address("gandhi street", "patel nagar", "sangli", 877232L);
		
	}

//	@Bean
//	public Address shippingAddress() {
//		
//		
//		return new Address("sector 102", "pocket 403", "gurugram", 577282L);
//		
//	}

	@Bean
	@Primary
	public Address shippingAddress() {
		
		
		return new Address("sector 102", "pocket 403", "gurugram", 577282L);
		
	}
	
}
