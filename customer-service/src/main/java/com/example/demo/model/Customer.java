package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "customer_nov_2021")
public class Customer {

	@Id
	@Column(name = "id")
	int customerId;
	
	@Column(name = "customername")
	String customerName;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "mobilenumber")
	long mobileNumber;
	
	
}
