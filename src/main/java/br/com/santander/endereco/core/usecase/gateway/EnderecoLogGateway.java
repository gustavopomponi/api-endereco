package br.com.santander.endereco.core.usecase.gateway;

import br.com.santander.endereco.dataprovider.repository.entity.LogEntity;

public interface EnderecoLogGateway {

    void saveLogEndereco(LogEntity entity);

}
