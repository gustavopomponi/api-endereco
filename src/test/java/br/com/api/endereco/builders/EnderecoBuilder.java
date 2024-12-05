package br.com.api.endereco.builders;

import br.com.api.endereco.core.usecase.entity.Endereco;

public class EnderecoBuilder {

    public static Endereco getEndereco() {

        return Endereco.builder()
                .cep("04617000")
                .logradouro("Rua Vieira de Morais")
                .complemento("de 1794 ao fim - lado par")
                .unidade("")
                .bairro("Campo Belo")
                .localidade("Sao Paulo")
                .uf("SP")
                .estado("São Paulo")
                .regiao("Sudeste")
                .ibge("3550308")
                .gia("1004")
                .ddd("11")
                .siafi("7107")
                .build();

    }

}
