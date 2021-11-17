package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		  auth.inMemoryAuthentication().withUser("india").password(encoder.encode("india")).roles("ADMIN")
//		  .and()
//		   .withUser("nepal").password(encoder.encode("nepal")).roles("USER");
//	
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		  auth.jdbcAuthentication()
		        .dataSource(dataSource)
		          .usersByUsernameQuery("SELECT username, password, enabled from users2 where username = ?")
		            .authoritiesByUsernameQuery("SELECT u.username, a.authority " +
		                    "FROM authorities a, users2 u " +
		                    "WHERE u.username = ? " +
		                    "AND u.username = a.username").passwordEncoder(encoder);	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		  .authorizeRequests()
		     .antMatchers("/menu/**")
		       .authenticated()
		          .and().csrf().disable()
		            .httpBasic();
	}
	
	
}
