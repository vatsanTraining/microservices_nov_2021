package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifaces.HotelRepository;
import com.example.demo.model.Hotel;
import com.example.demo.model.Review;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.*;
@RestController
@AllArgsConstructor
public class HotelController {
	
	
	@Autowired
	private HotelRepository repo;
	
	

	@GetMapping(path = "/hotels")
	public CollectionModel<Hotel> getAllHotels(){
		
		List<Hotel> hotelList = this.repo.findAll();
		
		System.out.println(hotelList);
		
		for(Hotel eachHotel : hotelList) {
			
			Set<Review> reviews = eachHotel.getReviews();
			
			 for(Review eachReview: reviews) {
				 
				 Link selfLink = WebMvcLinkBuilder
						   .linkTo(ReviewController.class)
						   .slash("reviews/"+eachReview.getId()).withSelfRel();
				 
				 eachHotel.add(selfLink);
			 }
			 
		}
		
		Link link = WebMvcLinkBuilder.linkTo(HotelController.class).withSelfRel();
				
		return CollectionModel.of(hotelList,link);
	}
}
