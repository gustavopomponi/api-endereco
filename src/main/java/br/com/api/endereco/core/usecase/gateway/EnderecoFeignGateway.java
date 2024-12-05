package br.com.api.endereco.core.usecase.gateway;


import br.com.api.endereco.core.usecase.entity.Endereco;

import java.util.Optional;

public interface EnderecoFeignGateway {

	 Optional<Endereco> getEndereco(String cep);

}
