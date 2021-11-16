package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class CustomInfoEndPoint implements InfoContributor {

	
	@Autowired
	ConfigurableApplicationContext ctx;
	@Override
	public void contribute(Builder builder) {

		   Map<String, Object> details = new HashMap<>();

		    details.put("application-name", ctx.getApplicationName());
	        details.put("bean-definition-count", ctx.getBeanDefinitionCount());
	        details.put("startup-date", ctx.getStartupDate());

	        builder.withDetail("context", details);

		
		
	}

}
