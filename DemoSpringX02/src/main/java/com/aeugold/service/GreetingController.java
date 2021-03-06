package com.aeugold.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicInteger counter = new AtomicInteger();
	
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
