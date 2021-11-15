package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifaces.ReviewRepository;
import com.example.demo.model.Review;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReviewController {

	
	
	private ReviewRepository repo;
	
	
	@GetMapping(path = "/reviews/{id}")
	public Review getReviewById(@PathVariable("id") String id) {
		
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
	}
	
}
