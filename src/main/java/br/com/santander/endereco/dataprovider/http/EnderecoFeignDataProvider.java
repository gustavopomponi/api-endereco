package br.com.santander.endereco.dataprovider.http;

import br.com.santander.endereco.configuration.exception.TechnicalException;
import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.core.usecase.gateway.EnderecoFeignGateway;
import br.com.santander.endereco.dataprovider.http.feign.EnderecoConsumer;
import br.com.santander.endereco.dataprovider.http.model.EnderecoResponseModel;
import br.com.santander.endereco.dataprovider.mapper.EnderecoMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EnderecoFeignDataProvider implements EnderecoFeignGateway {

	private final EnderecoConsumer consumer;

	@Override
	public Optional<Endereco> getEndereco(String cep) {

		Optional<Endereco> endereco = Optional.empty();

		try {

			ResponseEntity<EnderecoResponseModel> response = consumer.getEnderecoByCep(cep);

			if(response.getStatusCode().equals(HttpStatus.OK)) {
				endereco =  Optional.of(response.getBody()).map(EnderecoMapper::fromModelToCore);
			}

		} catch (FeignException ex) {
			throw new TechnicalException(ex);
		}

		return endereco;

	}

}
