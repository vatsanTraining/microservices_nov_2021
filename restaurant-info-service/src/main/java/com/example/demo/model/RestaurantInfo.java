package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Schmea For Restaurant Information")
public class RestaurantInfo {

	 @Id
	 @Column(name = "id")
	 @Schema(description = "The Id of the Restaurant", example = "veg-101 or nveg-202")
	 String id;
	 
	 @Column(name = "restaurantname")
	 @Schema(description = "The Name of restaurant",minLength = 5,maxLength = 30)

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
