package br.com.api.endereco.core.usecase.gateway;


import br.com.api.endereco.core.usecase.entity.Endereco;
import br.com.api.endereco.dataprovider.repository.entity.EnderecoEntity;

import java.util.Optional;

public interface EnderecoSaveGateway {

	Optional<Endereco> saveEndereco(EnderecoEntity entity);

}
