package com.aeugold.configuration.accessing;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mangofactory.swagger.plugin.EnableSwagger;

@Configuration
@EnableSwagger
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	
		// HOME
		registry.addViewController("/home").setViewName("/home/index");
		registry.addViewController("/home/").setViewName("/home/index");
		registry.addViewController("/").setViewName("/home/index");
		registry.addViewController("").setViewName("/home/index");
		
		// ADMIN
		registry.addViewController("/admin").setViewName("/admin/admin");
		registry.addViewController("/admin/").setViewName("/admin/admin");
		
		// LOGIN
		registry.addViewController("/login").setViewName("/login/login");
		registry.addViewController("/login/").setViewName("/login/login");
		
		// USER
		registry.addViewController("/user").setViewName("/user/user");
		registry.addViewController("/user/").setViewName("/user/user");
		
		// DEVELOPER
		registry.addViewController("/api").setViewName("/dba/dba");
		registry.addViewController("/api/").setViewName("/dba/dba");
		registry.addViewController("/api/swagger").setViewName("/dba/swagger");
		
		// PAGE ERROR
		registry.addViewController("/404").setViewName("/error/404");
		registry.addViewController("/403").setViewName("/error/403");
		
	}

}
