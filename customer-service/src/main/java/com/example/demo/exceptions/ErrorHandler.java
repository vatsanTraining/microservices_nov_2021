package com.example.demo.exceptions;

import java.time.LocalDateTime;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor

public class ErrorHandler {

	String message;
	String description;
	LocalDateTime dateTime;
	
	

}
