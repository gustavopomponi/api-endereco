package br.com.santander.endereco.dataprovider;

import br.com.santander.endereco.configuration.exception.TechnicalException;
import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.core.usecase.gateway.EnderecoSaveGateway;
import br.com.santander.endereco.dataprovider.mapper.EnderecoMapper;
import br.com.santander.endereco.dataprovider.repository.EnderecoRepository;
import br.com.santander.endereco.dataprovider.repository.entity.EnderecoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnderecoSaveDataProvider implements EnderecoSaveGateway {

	private final EnderecoRepository repository;

	@Override
	public Optional<Endereco> saveEndereco(EnderecoEntity entity) {

		Optional<Endereco> endereco;

		try {
			endereco = Optional.of(EnderecoMapper.fromEntityToCore(repository.save(entity)));
			return endereco;
		} catch (Exception e) {
			throw new TechnicalException(e);
		}

	}

}
