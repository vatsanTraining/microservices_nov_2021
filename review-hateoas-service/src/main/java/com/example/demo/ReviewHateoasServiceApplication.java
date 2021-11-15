package com.example.demo;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.ifaces.HotelRepository;
import com.example.demo.model.Hotel;
import com.example.demo.model.Review;
import java.util.*;
@SpringBootApplication
public class ReviewHateoasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewHateoasServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			HotelRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				Review  review1 = new Review("abc101","ramesh", "good ambience", 4.8);
				Review  review2 = new Review("abc102","rajesh", "Tasty Food", 4.8);
				
				Set<Review> reviews = new HashSet<>();
				 reviews.add(review1);
				 reviews.add(review2);
				 
				repo.save(new Hotel("veg-100","Sangeetha","chennai",9894949L,reviews));
			}
		};
	}
}
