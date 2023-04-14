package com.cepapi.controller.dto;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class that represents the data request for api", value = "ReqDto" )
public class ReqDto {
	
	@ApiModelProperty(notes = "Cep the address info", name = "cep", required = true, example = "01153000",position = 1)
	private String cep;
	
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReqDto other = (ReqDto) obj;
		return Objects.equals(cep, other.cep);
	}

}
