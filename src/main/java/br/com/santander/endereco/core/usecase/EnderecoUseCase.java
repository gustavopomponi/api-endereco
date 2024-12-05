package br.com.santander.endereco.core.usecase;


import br.com.santander.endereco.configuration.exception.EnderecoNaoEncontradoException;
import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.core.usecase.gateway.EnderecoDatabaseGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoFeignGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoLogGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoSaveGateway;
import br.com.santander.endereco.dataprovider.mapper.EnderecoMapper;
import br.com.santander.endereco.dataprovider.repository.entity.LogEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

import static br.com.santander.endereco.configuration.constants.LogConstant.DATABASE;
import static br.com.santander.endereco.configuration.constants.LogConstant.EXTERNAL_API;

@Component
@RequiredArgsConstructor
@Slf4j
public class EnderecoUseCase {

	private final EnderecoFeignGateway gatewayFeign;

	private final EnderecoDatabaseGateway gatewayDatabase;

	private final EnderecoSaveGateway saveGateway;

	private final EnderecoLogGateway logGateway;

	public Endereco buscarEnderecoPeloCep(String cep) {

		Optional<Endereco> optEndereco = gatewayDatabase.getEndereco(cep);

		if(optEndereco.isPresent()) {
			logEndereco(optEndereco.get(), DATABASE.value());
			return optEndereco.get();
		}

		Optional<Endereco> enderecoFeign = gatewayFeign.getEndereco(cep);

		if(enderecoFeign.isPresent()) {
			logEndereco(enderecoFeign.get(), EXTERNAL_API.value());
			return saveGateway.saveEndereco(EnderecoMapper.fromCoreToEntity(enderecoFeign.get())).get();
		} else {
			throw new EnderecoNaoEncontradoException(cep);
		}

	}

	private void logEndereco(Endereco endereco, String source) {
		logGateway.saveLogEndereco(LogEntity.builder().endereco(endereco).horario(LocalDateTime.now()).source(source).build());
	}


}
