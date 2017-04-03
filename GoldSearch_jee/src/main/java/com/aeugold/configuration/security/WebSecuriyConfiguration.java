package com.aeugold.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecuriyConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetail")
	private UserDetailsService userDetailsService;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
//		auth.inMemoryAuthentication().withUser("dba").password("123").roles("DBA");
		
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/", "/home", "/loginX/").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/api/**").hasAnyRole("DBA", "ADMIN");

		http
		.formLogin()
		.permitAll()
		.loginPage("/login")
		.loginPage("/login/")
		.passwordParameter("password")
		.usernameParameter("username");

		http.csrf().disable();

	}
}
