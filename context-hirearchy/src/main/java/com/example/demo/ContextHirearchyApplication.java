package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.config.MyChildContext;
import com.example.demo.model.Customer;

@SpringBootApplication
public class ContextHirearchyApplication {

	public static void main(String[] args) {

	ConfigurableApplicationContext ctx =new SpringApplicationBuilder(ContextHirearchyApplication.class)
		   .child(MyChildContext.class).run(args);
	
	       System.out.println(ctx.getBean("parentCustomer",Customer.class));
	       
	       System.out.println("Parent Customer ="+ctx.isSingleton("parentCustomer"));
	       
	       System.out.println(ctx.getBean("childCustomer",Customer.class));
	       
	       System.out.println("Child Customer =" +ctx.isSingleton("childCustomer"));

	}

	
	@Bean(name ="parentCustomer")
	public Customer ramesh() {
		
		return new Customer(101,"Parent Ramesh",8484848,"pram@abc.com");
		
	}
}
