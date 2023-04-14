package com.cepapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cepapi.controller.dto.ReqDto;
import com.cepapi.model.Endereco;
import com.google.gson.Gson;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CepTestValid extends TestCucumber {
	
	ResponseEntity<Endereco> response;

	private final Gson gson = new Gson();
	private static final Logger log = LoggerFactory.getLogger(ApiCepApplicationTests.class);
	
	@When("User call v1/consulta-endereco Endpoint to fetch information from the requested zip code valid")
	public void postCepApi() {
		// POST
		log.info("Request api to fetch the zip code information cep valid");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("01001000");
		response = new RestTemplate().postForEntity("/v1/consulta-endereco", cepDto, Endereco.class);
	}
	
	
	@Then("Validates the status and information returned from the call to verify that it came in line cep valid")
	public void postValidCepApi() {
		log.info("Return body data cucumber cep valid: " + gson.toJson(response.getBody()));

		log.info("Validates the status if your callback was ok (200)");
		assertEquals(HttpStatus.OK, response.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(response.getBody());

		log.info("Checks if the zip code of the address did not come null");
		assertNotNull(response.getBody().getCep());

		log.info("Validates if the returned state is the same as the condition");
		assertEquals("SP", response.getBody().getEstado());

		log.info("Validates if the freight value is greater than 7");
		assertTrue(response.getBody().getFrete() > 7);
	}

}
