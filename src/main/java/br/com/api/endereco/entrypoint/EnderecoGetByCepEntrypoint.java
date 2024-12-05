package br.com.api.endereco.entrypoint;


import br.com.api.endereco.core.usecase.EnderecoUseCase;
import br.com.api.endereco.core.usecase.entity.Endereco;
import br.com.api.endereco.entrypoint.mapper.EnderecoEntrypointMapper;
import br.com.api.endereco.entrypoint.model.EnderecoEntrypointResponseModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EnderecoGetByCepEntrypoint {

	private final EnderecoUseCase usecase;

	@GetMapping(value = "/endereco/{cep}", produces = "application/json")
	public ResponseEntity<EnderecoEntrypointResponseModel>
	getEnderecoByCep(@PathVariable @NotBlank @Size(min =8, max = 8) String cep) {

		Endereco endereco = usecase.buscarEnderecoPeloCep(cep);

		return ResponseEntity.ok()
				.body(EnderecoEntrypointMapper.fromCoreToModel(endereco));


	}

}