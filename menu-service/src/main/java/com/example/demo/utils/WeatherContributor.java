package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Endpoint(id = "weather")

public class WeatherContributor {

	
	private String currentTemp ="31C";
	
	
	
	
	@ReadOperation
	public String currentTemp() {
		
		return this.currentTemp;
	}
	
	@WriteOperation
	public String updateTemp(@Selector String temp) {
		
		this.currentTemp = temp;
		
		return this.currentTemp;
	}
}
