package br.com.api.endereco.dataprovider.repository;

import br.com.api.endereco.dataprovider.repository.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, Integer> {}