package com.cepapi.util;

import java.util.*;

import com.cepapi.model.Endereco;
import com.cepapi.service.dto.CepDTO;

public class Util {

	private static Map<String, Double> getStates() {
		Map<String, Double> states = new HashMap<String, Double>();
		// Regiao Sul
		states.put("RS", 17.30);
		states.put("SC", 17.30);
		states.put("PR", 17.30);

		// Regiao Sudeste
		states.put("ES", 7.85);
		states.put("MG", 7.85);
		states.put("RJ", 7.85);
		states.put("SP", 7.85);

		// Regiao Centro-Oeste
		states.put("DF", 12.50);
		states.put("GO", 12.50);
		states.put("MT", 12.50);
		states.put("MS", 12.50);

		// Regiao Nordeste
		states.put("AL", 15.98);
		states.put("BA", 15.98);
		states.put("CE", 15.98);
		states.put("MA", 15.98);
		states.put("PB", 15.98);
		states.put("PI", 15.98);
		states.put("PE", 15.98);
		states.put("RN", 15.98);
		states.put("SE", 15.98);

		// Regiao Norte
		states.put("AC", 20.83);
		states.put("AP", 20.83);
		states.put("AM", 20.83);
		states.put("PA", 20.83);
		states.put("RO", 20.83);
		states.put("RR", 20.83);
		states.put("TO", 20.83);

		return states;
	}

	public static boolean validCep(String cep) {

		if (cep.isBlank() || cep.isEmpty() || !cep.matches("[0-9]{8}"))
			return false;
		
		return true;
	}
	
	public static String formatCep(String cep) {
		return cep.replaceAll("[^0-9]+", "");
	}
	
	public static Endereco formatObjCep(CepDTO cepDto) {
		var endereco = new Endereco();
		endereco.setCep(cepDto.getCep());
		endereco.setComplemento(cepDto.getComplemento());
		endereco.setRua(cepDto.getLogradouro());
		endereco.setCidade(cepDto.getLocalidade());
		endereco.setEstado(cepDto.getUf());
		endereco.setBairro(cepDto.getBairro());
		endereco.setFrete(getStates().get(cepDto.getUf()));
		
		return endereco;
	}

}
