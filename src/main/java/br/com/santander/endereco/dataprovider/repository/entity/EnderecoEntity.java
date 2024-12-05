package br.com.santander.endereco.dataprovider.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cep")
public class EnderecoEntity implements Serializable {

	private static final long serialVersionUID = -340253547645266531L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "cep")
	private String cep;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "localidade")
	private String localidade;

	@Column(name = "uf")
	private String uf;

	@Column(name = "unidade")
	private String unidade;

	@Column(name = "ibge")
	private String ibge;

	@Column(name = "gia")
	private String gia;

}



