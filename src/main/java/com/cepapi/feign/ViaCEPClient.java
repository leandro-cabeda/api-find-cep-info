package com.cepapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cepapi.service.dto.CepDTO;

@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPClient {
	
	@GetMapping("{cep}/json")
	CepDTO findCep(@PathVariable("cep") String cep);
}
