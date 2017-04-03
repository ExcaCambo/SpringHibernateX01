package com.aeugold.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMVC extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	
		// HOME
		registry.addViewController("/home").setViewName("/home/index");
		registry.addViewController("/home/").setViewName("/home/index");
		registry.addViewController("/").setViewName("/home/index");
		registry.addViewController("").setViewName("/home/index");
		
		// PAGE ERROR
		registry.addViewController("/404").setViewName("/error/404");
		registry.addViewController("/403").setViewName("/error/403");
	}
}
