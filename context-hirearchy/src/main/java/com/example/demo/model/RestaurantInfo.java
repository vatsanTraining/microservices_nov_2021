package com.example.demo.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor

public class RestaurantInfo {

	 String id;
	 String restaurantName;
	 String location;
	 long mobileNumber;
	public RestaurantInfo() {
		super();

		System.out.println("Restaurant Info Bean Initialized");
	}
	 
	 
}
