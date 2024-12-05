package br.com.api.endereco.core.usecase.gateway;

import br.com.api.endereco.dataprovider.repository.entity.LogEntity;

public interface EnderecoLogGateway {

    void saveLogEndereco(LogEntity entity);

}
