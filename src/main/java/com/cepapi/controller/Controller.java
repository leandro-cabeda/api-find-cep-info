package com.cepapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cepapi.controller.dto.ReqDto;
import com.cepapi.model.Endereco;
import com.cepapi.service.ServiceApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(tags = { "Find Cep EndPoint" })
public class Controller {

	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private ServiceApi service;

	@GetMapping
	@ApiOperation(value = "Initial presentation of welcome Api Cep")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Welcome Api Cep") })
	public ResponseEntity<String> welcome() {
		log.info("Welcome Api Find CEP");
		return ResponseEntity.ok("Welcome Api Find CEP");
	}

	@PostMapping(value = "v1/consulta-endereco", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Search Cep in request body")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Search Cep in Api"),
			@ApiResponse(code = 404, message = "Cep Info not found"),
			@ApiResponse(code = 400, message = "Invalid Cep Info (BadRequest)"),
			@ApiResponse(code = 500, message = "Internal error") })
	public ResponseEntity<?> findCep(@RequestBody ReqDto dtoCep) {
		log.info("Search by cep info!");

		Endereco endereco = service.findCep(dtoCep.getCep());

		if (endereco == null) {
			return ResponseEntity.badRequest().body("Invalid zip code entered when searching");
		} else if (endereco != null && (endereco.getCep() == null || endereco.getCep().isEmpty())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cep not found!!");
		}

		return ResponseEntity.ok(endereco);
	}
}
