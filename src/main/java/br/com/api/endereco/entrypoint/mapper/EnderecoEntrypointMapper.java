/**
 *
 */
package br.com.api.endereco.entrypoint.mapper;

import br.com.api.endereco.core.usecase.entity.Endereco;
import br.com.api.endereco.entrypoint.model.EnderecoEntrypointResponseModel;

public class EnderecoEntrypointMapper {

	private EnderecoEntrypointMapper() {	}

	public static EnderecoEntrypointResponseModel fromCoreToModel(Endereco endereco) {

		return EnderecoEntrypointResponseModel.builder()
				.cep(endereco.getCep())
				.logradouro(endereco.getLogradouro())
				.complemento(endereco.getComplemento())
				.bairro(endereco.getBairro())
				.localidade(endereco.getLocalidade())
				.uf(endereco.getUf())
				.unidade(endereco.getUnidade())
				.ibge(endereco.getIbge())
				.gia(endereco.getGia())
				.build();


	}

}
