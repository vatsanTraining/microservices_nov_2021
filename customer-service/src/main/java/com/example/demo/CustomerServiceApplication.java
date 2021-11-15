package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.ifaces.CustomerRepository;
import com.example.demo.model.Customer;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {

				
				repo.save(new Customer(201,"Ramesh", "ram@abc.com", 848482));
				
				
				repo.save(new Customer(202,"Suresh", "sur@abc.com", 748477));
				
				
				repo.save(new Customer(203,"Magesh", "mag@abc.com", 64867782));

			}
		};
	}
	
		
	
}
