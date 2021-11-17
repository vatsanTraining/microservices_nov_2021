package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MenuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuServiceApplication.class, args);
	
		
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
			     
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			        System.out.println(encoder.encode("india"));
			        System.out.println(encoder.encode("nepal"));
			  				
			}
		};
		
	}
}
