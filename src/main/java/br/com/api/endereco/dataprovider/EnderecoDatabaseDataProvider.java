package br.com.api.endereco.dataprovider;


import br.com.api.endereco.core.usecase.entity.Endereco;
import br.com.api.endereco.core.usecase.gateway.EnderecoDatabaseGateway;
import br.com.api.endereco.dataprovider.mapper.EnderecoMapper;
import br.com.api.endereco.dataprovider.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnderecoDatabaseDataProvider implements EnderecoDatabaseGateway {

	private final EnderecoRepository repository;

	@Override
	public Optional<Endereco> getEndereco(String cep){

		return Optional.of(repository.findByCep(cep).map(EnderecoMapper::fromEntityToCore))
				.orElse(Optional.empty());

	}

}
