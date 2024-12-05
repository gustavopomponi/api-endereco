package br.com.santander.endereco;

import org.springframework.boot.SpringApplication;

public class TestEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.from(EnderecoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
