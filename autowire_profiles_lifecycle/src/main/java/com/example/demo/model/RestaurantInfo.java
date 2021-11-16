package com.example.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
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
	 
	 /*
	  *   0 bean => throws exception or set to null
	  *   1 bean => works without exception
	  *   2 or more bean => throws exception use either @Qualifier or @Primary 
	  */
	 
	 @Autowired
	 @Qualifier(value = "billingAddress")
	 Address address1;

	 @Autowired
	 Address address2;
	 
//	 @Autowired
//	 Address address;

//	 @Autowired(required = false)
//	 Address address;

	 
	public RestaurantInfo(String id, String restaurantName, String location, long mobileNumber) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.location = location;
		this.mobileNumber = mobileNumber;
	}
	
	@Autowired
	Environment env;
		
	@PostConstruct
	public void init() {
		
		System.out.println("From Init Method Profile Count :="+ env.getActiveProfiles().length);
		
	}
	 
	
	@PreDestroy
	public void destroy() {
		
		System.out.println("Destory Method Called");
		
	}
}
