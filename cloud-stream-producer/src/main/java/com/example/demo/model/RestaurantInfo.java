package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Slf4j

@Entity
@Table(name = "restaurant_nov2021")
public class RestaurantInfo {

	 @Id
	 @Column(name = "id")
	 String id;
	 
	 @Column(name = "restaurantname")

	 String restaurantName;
	 
	 @Column(name = "location")
	 String location;
	 
	 @Column(name = "mobilenumber")
	 long mobileNumber;

	 public RestaurantInfo() {
		super();

		log.debug("Restaurant Info Bean Initialized");
	}
	 
	 
}
