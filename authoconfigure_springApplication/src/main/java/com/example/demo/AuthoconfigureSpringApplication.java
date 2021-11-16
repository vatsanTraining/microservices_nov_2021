package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.model.Customer;
import com.example.demo.utils.MyConditional;

@SpringBootApplication
public class AuthoconfigureSpringApplication {

	public static void main(String[] args) {
		
		Banner.Mode offMode = Banner.Mode.OFF;
		
		Map<String,Object> props = new HashMap<>();
		 props.put("server.port", "5055");
		 props.put("spring.config.name", "custom");
		 
		ConfigurableApplicationContext ctx = 
				new SpringApplicationBuilder(AuthoconfigureSpringApplication.class)
				.bannerMode(offMode)
                  .properties(props)
                     .build()
                       .run(args);

		 Customer ram = ctx.getBean(Customer.class);
		 
		 System.out.println(ram);
	}

	@Bean
	@ConditionalOnProperty(name = "spring.application.name",havingValue = "autoconfig")
	public Customer suresh() {
		
		return new Customer(102,"Suresh",5848482L,"sur@abc.com");
	}

	@Bean
	@Conditional(MyConditional.class)
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh",8848482L,"ram@abc.com");
	}
}
