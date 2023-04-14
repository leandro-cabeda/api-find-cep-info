package com.cepapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cepapi.exception.CepNotFound;
import com.cepapi.feign.ViaCEPClient;
import com.cepapi.model.Endereco;
import com.cepapi.util.Util;

@Service
public class ServiceApi {

	@Autowired
	ViaCEPClient viaCEPClient;

	public Endereco findCep(String cep) {

		cep = Util.formatCep(cep);

		if (!Util.validCep(cep))
			return null;

		try {
			return Util.formatObjCep(viaCEPClient.findCep(cep));
		} catch (Exception e) {
			throw new CepNotFound("Cep not found!!");
		}
	}
}
