package br.com.api.endereco.dataprovider.http.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponseModel {

	@JsonProperty("cep")
	private String cep;

	@JsonProperty("logradouro")
	private String logradouro;

	@JsonProperty("complemento")
	private String complemento;

	@JsonProperty("bairro")
	private String bairro;

	@JsonProperty("unidade")
	private String unidade;

	@JsonProperty("localidade")
	private String localidade;

	@JsonProperty("uf")
	private String uf;

	@JsonProperty("estado")
	private String estado;

	@JsonProperty("regiao")
	private String regiao;

	@JsonProperty("ibge")
	private String ibge;

	@JsonProperty("gia")
	private String gia;

	@JsonProperty("ddd")
	private String ddd;

	@JsonProperty("siafi")
	private String siafi;



}
