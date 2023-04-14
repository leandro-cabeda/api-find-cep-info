package com.cepapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WelcomeTest extends TestCucumber {

	ResponseEntity<String> response;

	private static final Logger log = LoggerFactory.getLogger(ApiCepApplicationTests.class);

	@When("User call Welcome Api Endpoint Main")
	public void welcomeApi() {
		// GET
		log.info("Request api path main (Welcome)");
		response = new RestTemplate().getForEntity("http://localhost:5000", String.class);

	}

	@Then("Return status and message")
	public void validStatusMessageWelcome() {
		log.info("Validates the status if your callback was ok (200)");
		assertEquals(HttpStatus.OK, response.getStatusCode());

		log.info("Validates that the body message is the same as the condition");
		assertEquals("Welcome Api Find CEP", response.getBody());
	}
}
