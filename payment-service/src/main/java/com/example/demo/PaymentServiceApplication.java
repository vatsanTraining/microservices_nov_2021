package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.ifaces.PaymentRepository;
import com.example.demo.model.Payment;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			
			@Autowired
			PaymentRepository repo;
			@Override
			public void run(String... args) throws Exception {

				
				repo.save(new Payment(901, LocalDate.now(), 8000, "Ramesh"));
				repo.save(new Payment(902, LocalDate.now(), 27000, "Suresh"));
				repo.save(new Payment(903, LocalDate.now(), 85000, "Magesh"));
				
				

			}
		};
	}

		
}
