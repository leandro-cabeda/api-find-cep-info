package com.cepapi.service.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing the zip code information sought", value = "CepDTO" )
public class CepDTO {
	
	@ApiModelProperty(notes = "Cep the address info", name = "cep", required = true, example = "01153000",position = 1)
	private String cep;
	
	@ApiModelProperty(notes = "Logradouro the address info", name = "logradouro", required = true, example = "General Salton",position = 2)
    private String logradouro;
	
	@ApiModelProperty(notes = "Complemento the address info", name = "complemento", required = true, example = "Casa",position = 3)
    private String complemento;
	
	@ApiModelProperty(notes = "Bairro the address info", name = "bairro", required = true, example = "Vila Vergueiro",position = 4)
    private String bairro;
	
	@ApiModelProperty(notes = "Localidade the address info", name = "localidade", required = true, example = "São Paulo",position = 5)
    private String localidade;
	
	@ApiModelProperty(notes = "UF the address info", name = "uf", required = true, example = "SP",position = 6)
    private String uf;
    
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, localidade, logradouro, uf);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CepDTO other = (CepDTO) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(localidade, other.localidade)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(uf, other.uf);
	}
	
	@Override
	public String toString() {
		return "CepDTO [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}

}
