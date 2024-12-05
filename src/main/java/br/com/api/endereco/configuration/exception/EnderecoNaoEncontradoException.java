package br.com.api.endereco.configuration.exception;


public class EnderecoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EnderecoNaoEncontradoException(String cep) {
		super(String.format("Endereco com cep %s não encontrado", cep));
	}

}
