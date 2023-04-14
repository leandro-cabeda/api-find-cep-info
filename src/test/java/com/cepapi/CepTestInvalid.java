package com.cepapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cepapi.controller.dto.ReqDto;
import com.google.gson.Gson;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CepTestInvalid extends TestCucumber {

	ResponseEntity<String> response;

	private final Gson gson = new Gson();
	private static final Logger log = LoggerFactory.getLogger(ApiCepApplicationTests.class);

	@When("User call v1/consulta-endereco Endpoint to fetch information from the requested zip code invalid not found")
	public void postCepNotFoundApi() {
		// POST
		log.info("Request api to fetch the zip code information not found");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("01000222");
		response = new RestTemplate().postForEntity("/v1/consulta-endereco", cepDto, String.class);
	}

	@When("User call v1/consulta-endereco Endpoint to fetch information from the requested zip code invalid bad request")
	public void postCepBadRequestApi() {
		// POST
		log.info("Request api to fetch the zip code information bad request");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("010008222");
		response = new RestTemplate().postForEntity("/v1/consulta-endereco", cepDto, String.class);
	}

	@Then("Validates the status and information returned from the call to verify that it came in line not found cep")
	public void postInvalidCepNotFoundApi() {
		log.info("Return body data cucumber cep invalid not found: " + gson.toJson(response.getBody()));

		log.info("Validates the status if your callback was not found (404)");
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(response.getBody());

		log.info("Checks the message if the previous zip code returned was null in the information");
		assertEquals("Cep not found!!", response.getBody());
	}

	@Then("Validates the status and information returned from the call to verify that it came in line bad request cep")
	public void postInvalidCepBadRequestApi() {
		log.info("Return body data cucumber cep invalid bad request: " + gson.toJson(response.getBody()));

		log.info("Validates the status if your callback was bad request (400)");
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(response.getBody());

		log.info("Checks the message if the previous zip code returned was invalid");
		assertEquals("Invalid zip code entered when searching", response.getBody());
		
	}

}
