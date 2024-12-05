package br.com.santander.endereco.dataprovider.repository.entity;

import br.com.santander.endereco.core.usecase.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "logs")
public class LogEntity {

    private LocalDateTime horario;
    private String source;
    private Endereco endereco;

}
