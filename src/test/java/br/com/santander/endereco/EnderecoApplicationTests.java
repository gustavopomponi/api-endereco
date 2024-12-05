package br.com.santander.endereco;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EnderecoApplicationTests {

	@Test
	void contextLoads() {
	}

}
