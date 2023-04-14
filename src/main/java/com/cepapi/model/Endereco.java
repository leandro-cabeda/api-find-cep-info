package com.cepapi.model;

import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class that represents the address",  value = "Endereco")
public class Endereco {
	
	@ApiModelProperty(notes = "Cep the address", name = "cep", required = true, example = "01153000",position = 1)
	private String cep;
	
	@ApiModelProperty(notes = "Rua the address", name = "rua", required = true, example = "General Salton",position = 2)
    private String rua;
	
	@ApiModelProperty(notes = "Complemento the address", name = "complemento", required = true, example = "Casa",position = 3)
    private String complemento;
	
	@ApiModelProperty(notes = "Bairro the address", name = "bairro", required = true, example = "Vila Vergueiro",position = 4)
    private String bairro;
	
	@ApiModelProperty(notes = "Cidade the address", name = "cidade", required = true, example = "São Paulo",position = 5)
    private String cidade;
	
	@ApiModelProperty(notes = "Estado the address", name = "estado", required = true, example = "SP",position = 6)
    private String estado;
	
	@ApiModelProperty(notes = "Frete the address", name = "frete", required = true, example = "20.83",position = 7)
    private Double frete;
    
    
    
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getFrete() {
		return frete;
	}
	public void setFrete(Double frete) {
		this.frete = frete;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, frete, rua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(frete, other.frete)
				&& Objects.equals(rua, other.rua);
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", frete=" + frete + "]";
	}
    

}
