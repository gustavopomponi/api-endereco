/**
 *
 */
package br.com.api.endereco.core.usecase.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String unidade;
	private String localidade;
	private String uf;
	private String estado;
	private String regiao;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;

}
