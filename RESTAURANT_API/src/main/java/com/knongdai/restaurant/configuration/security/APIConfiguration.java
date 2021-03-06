package com.knongdai.restaurant.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;



@Configuration
@EnableWebSecurity
@Order(1)
public class APIConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("RESTAuthenticationEntryPoint")
	private RESTAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**")
			.authorizeRequests()
			.anyRequest().permitAll();//hasRole("API_DEVELOPER");
		http.csrf().disable();
		
		http.httpBasic()
		.authenticationEntryPoint(restAuthenticationEntryPoint);

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	
	
}
