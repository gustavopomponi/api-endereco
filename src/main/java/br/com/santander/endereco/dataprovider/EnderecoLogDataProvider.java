package br.com.santander.endereco.dataprovider;

import br.com.santander.endereco.core.usecase.gateway.EnderecoLogGateway;
import br.com.santander.endereco.dataprovider.repository.LogRepository;
import br.com.santander.endereco.dataprovider.repository.entity.LogEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoLogDataProvider implements EnderecoLogGateway {

    private final LogRepository logRepository;

    @Override
    public void saveLogEndereco(LogEntity entity) {
        logRepository.save(entity);
    }

}
