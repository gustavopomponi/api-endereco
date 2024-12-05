package br.com.api.endereco.dataprovider.http.feign;


import br.com.api.endereco.dataprovider.http.model.EnderecoResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "endereco-consumer", url = "${endereco.url}")
public interface EnderecoConsumer {

    @GetMapping(value = "/{cep}/json/", produces = "application/json")
    ResponseEntity<EnderecoResponseModel> getEnderecoByCep(@PathVariable("cep") String cep);

}
