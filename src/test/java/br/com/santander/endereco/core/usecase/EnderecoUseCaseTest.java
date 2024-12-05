package br.com.santander.endereco.core.usecase;

import br.com.santander.endereco.builders.EnderecoBuilder;
import br.com.santander.endereco.configuration.exception.EnderecoNaoEncontradoException;
import br.com.santander.endereco.core.usecase.entity.Endereco;
import br.com.santander.endereco.core.usecase.gateway.EnderecoFeignGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoDatabaseGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoLogGateway;
import br.com.santander.endereco.core.usecase.gateway.EnderecoSaveGateway;
import br.com.santander.endereco.dataprovider.repository.entity.EnderecoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EnderecoUseCaseTest {

    @InjectMocks
    private EnderecoUseCase enderecoUseCase;

    @Mock
    private EnderecoFeignGateway enderecoFeignGateway;

    @Mock
    private EnderecoDatabaseGateway enderecoDatabaseGateway;

    @Mock
    private EnderecoSaveGateway enderecoSaveGateway;

    @Mock
    private EnderecoLogGateway enderecoLogGateway;


    @Test
    void enderecoGetByCepSuccessNoRecordOnDatabase() {

        Endereco endereco = EnderecoBuilder.getEndereco();

        when(enderecoDatabaseGateway.getEndereco(anyString())).thenReturn(Optional.empty());
        when(enderecoFeignGateway.getEndereco(anyString())).thenReturn(Optional.of(endereco));
        when(enderecoSaveGateway.saveEndereco(any(EnderecoEntity.class))).thenReturn(Optional.of(endereco));

        enderecoUseCase.buscarEnderecoPeloCep("04617007");

        verify(enderecoDatabaseGateway, times(1)).getEndereco(anyString());
        verify(enderecoFeignGateway, times(1)).getEndereco(anyString());
        verify(enderecoSaveGateway, times(1)).saveEndereco(any(EnderecoEntity.class));

    }

    @Test
    void enderecoGetByCepSuccessRecordExistsOnDatabase() {

        Endereco endereco = EnderecoBuilder.getEndereco();

        when(enderecoDatabaseGateway.getEndereco(anyString())).thenReturn(Optional.of(endereco));

        enderecoUseCase.buscarEnderecoPeloCep("04617007");

        verify(enderecoDatabaseGateway, times(1)).getEndereco(anyString());
        verify(enderecoFeignGateway, never()).getEndereco(anyString());
        verify(enderecoSaveGateway, never()).saveEndereco(any(EnderecoEntity.class));

    }

    @Test
    void enderecoGetByCepSuccessCpfNotFound() {

        when(enderecoDatabaseGateway.getEndereco(anyString())).thenReturn(Optional.empty());
        when(enderecoFeignGateway.getEndereco(anyString())).thenReturn(Optional.empty());

        EnderecoNaoEncontradoException thrown = assertThrows(
                EnderecoNaoEncontradoException.class,
                () -> enderecoUseCase.buscarEnderecoPeloCep("04617007")
        );

        verify(enderecoDatabaseGateway, times(1)).getEndereco(anyString());
        verify(enderecoFeignGateway, times(1)).getEndereco(anyString());
        verify(enderecoSaveGateway, never()).saveEndereco(any(EnderecoEntity.class));

    }

}
