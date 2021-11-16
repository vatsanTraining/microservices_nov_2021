package com.example.demo.utils;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		return context.getEnvironment()
				.getProperty("logging.level.org.springframework.boot")
				 .equals("trace");
		
		
		 		
		// return false;
	}

}
