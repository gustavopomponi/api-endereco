package br.com.santander.endereco.core.usecase.gateway;


import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.dataprovider.repository.entity.EnderecoEntity;

import java.util.Optional;

public interface EnderecoSaveGateway {

	Optional<Endereco> saveEndereco(EnderecoEntity entity);

}
