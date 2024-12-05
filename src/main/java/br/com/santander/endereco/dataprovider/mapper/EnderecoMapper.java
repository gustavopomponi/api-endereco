package br.com.santander.endereco.dataprovider.mapper;

import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.dataprovider.http.model.EnderecoResponseModel;
import br.com.santander.endereco.dataprovider.repository.entity.EnderecoEntity;

public class EnderecoMapper {

    private EnderecoMapper() {}

    public static Endereco fromModelToCore(EnderecoResponseModel model) {

        return Endereco.builder()
                .cep(model.getCep())
                .logradouro(model.getLogradouro())
                .complemento(model.getComplemento())
                .bairro(model.getBairro())
                .localidade(model.getLocalidade())
                .uf(model.getUf())
                .unidade(model.getUnidade())
                .ibge(model.getIbge())
                .gia(model.getGia())
                .build();

    }

    public static Endereco fromEntityToCore(EnderecoEntity entity) {

        return Endereco.builder()
                .cep(entity.getCep())
                .logradouro(entity.getLogradouro())
                .complemento(entity.getComplemento())
                .bairro(entity.getBairro())
                .localidade(entity.getLocalidade())
                .uf(entity.getUf())
                .unidade(entity.getUnidade())
                .ibge(entity.getIbge())
                .gia(entity.getGia())
                .build();
    }

    public static EnderecoEntity fromCoreToEntity(Endereco core) {

        return EnderecoEntity.builder()
                .cep(core.getCep().replace("-", ""))
                .logradouro(core.getLogradouro())
                .complemento(core.getComplemento())
                .bairro(core.getBairro())
                .localidade(core.getLocalidade())
                .uf(core.getUf())
                .unidade(core.getUnidade())
                .ibge(core.getIbge())
                .gia(core.getGia())
                .id(0l)
                .build();
    }

}
