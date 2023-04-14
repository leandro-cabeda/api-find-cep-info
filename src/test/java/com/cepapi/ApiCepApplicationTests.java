package com.cepapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cepapi.controller.dto.ReqDto;
import com.cepapi.model.Endereco;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = ApiCepApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiCepApplicationTests {

	@Autowired
	protected TestRestTemplate rest;

	private final Gson gson = new Gson();
	private static final Logger log = LoggerFactory.getLogger(ApiCepApplicationTests.class);

	@Test
	void welcomeApi() {

		// GET
		log.info("Request api path main (Welcome)");
		ResponseEntity<String> res = rest.getForEntity("/", String.class);

		log.info("Validates the status if your callback was ok (200)");
		assertEquals(HttpStatus.OK, res.getStatusCode());

		log.info("Validates that the body message is the same as the condition");
		assertEquals("Welcome Api Find CEP", res.getBody());
	}

	@Test
	void postValidCepInfoApi() {

		// POST
		log.info("Request api to fetch the zip code information");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("01001000");

		ResponseEntity<Endereco> res = rest.postForEntity("/v1/consulta-endereco", cepDto, Endereco.class);

		log.info("Return body: " + gson.toJson(res.getBody()));

		log.info("Validates the status if your callback was ok (200)");
		assertEquals(HttpStatus.OK, res.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(res.getBody());

		log.info("Checks if the zip code of the address did not come null");
		assertNotNull(res.getBody().getCep());

		log.info("Validates if the returned state is the same as the condition");
		assertEquals("SP", res.getBody().getEstado());

		log.info("Validates if the freight value is greater than 7");
		assertTrue(res.getBody().getFrete() > 7);
	}

	@Test
	void postInvalidCepNotFoundApi() {

		// POST
		log.info("Request api to fetch the zip code information");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("01000222");

		ResponseEntity<String> res = rest.postForEntity("/v1/consulta-endereco", cepDto, String.class);

		log.info("Return body: " + gson.toJson(res.getBody()));

		log.info("Validates the status if your callback was not found (404)");
		assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(res.getBody());

		log.info("Checks the message if the previous zip code returned was null in the information");
		assertEquals("Cep not found!!", res.getBody());

	}

	@Test
	void postInvalidCepBadRequestApi() {
		// POST
		log.info("Request api to fetch the zip code information");
		ReqDto cepDto = new ReqDto();
		cepDto.setCep("010008222");

		ResponseEntity<String> res = rest.postForEntity("/v1/consulta-endereco", cepDto, String.class);

		log.info("Return body: " + gson.toJson(res.getBody()));

		log.info("Validates the status if your callback was bad request (400)");
		assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());

		log.info("Checks if the body of the address did not come with null");
		assertNotNull(res.getBody());

		log.info("Checks the message if the previous zip code returned was invalid");
		assertEquals("Invalid zip code entered when searching", res.getBody());
	}

}
