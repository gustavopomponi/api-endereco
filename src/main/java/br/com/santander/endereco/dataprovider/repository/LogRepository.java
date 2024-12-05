package br.com.santander.endereco.dataprovider.repository;

import br.com.santander.endereco.dataprovider.repository.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogEntity, Integer> {}