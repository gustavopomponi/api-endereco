package br.com.api.endereco.dataprovider.repository;

import br.com.api.endereco.dataprovider.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
	Optional<EnderecoEntity> findByCep(String cep);

}
