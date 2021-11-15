package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import java.util.*;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

@Entity
@Table(name = "Hotel_Nov_2021")
public class Hotel extends RepresentationModel<Review> {

	 @Id
	 @Column(name = "id")
	 String id;
	 
	 @Column(name = "restaurantname")
	 String restaurantName;
	 
	 @Column(name = "location")
	 String location;
	 
	 @Column(name = "mobilenumber")
	 long mobileNumber;

	
	 @OneToMany(targetEntity =Review.class,  
			 cascade = CascadeType.ALL,
			             fetch=FetchType.EAGER)
			     @JoinColumn(name = "review_ref" , referencedColumnName = "id")
			  
			 @JsonIgnore
	 Set<Review> reviews;
	 
}
