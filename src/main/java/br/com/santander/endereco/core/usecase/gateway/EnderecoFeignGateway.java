package br.com.santander.endereco.core.usecase.gateway;


import br.com.santander.endereco.core.usecase.entity.Endereco;

import java.util.Optional;

public interface EnderecoFeignGateway {

	 Optional<Endereco> getEndereco(String cep);

}
