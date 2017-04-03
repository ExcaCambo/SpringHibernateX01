package com.aeugold.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.atomikos.logging.Logger;
import com.atomikos.logging.LoggerFactory;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.createLogger(Application.class);

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.logInfo(quote.toString());
	}
}
