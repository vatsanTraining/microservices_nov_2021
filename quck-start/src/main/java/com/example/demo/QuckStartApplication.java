package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.model.RestaurantInfo;

@SpringBootApplication
public class QuckStartApplication {

	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx =SpringApplication.run(QuckStartApplication.class, args);
	
		System.out.println(ctx.getClass().getName());
		
	
//		Customer ram = ctx.getBean(Customer.class);
//		
//		System.out.println(ram);
//		
//		
	
		// RestaurantInfo sangeetha = ctx.getBean(RestaurantInfo.class);
		
//		RestaurantInfo sangeetha = ctx.getBean("hotel",RestaurantInfo.class);
//		
//		System.out.println(sangeetha);
//		
//		System.out.println("Is Singleton - Expected: false => " +ctx.isSingleton("hotel"));
//		System.out.println("Is Prototype - Expected: true => " +ctx.isPrototype("hotel"));
	}
	
	@Bean
	public Customer ram() {
		
		return new Customer(101,"Ramesh",4848482L,"ram@abc.com");
	}

}
