/**
 *
 */
package br.com.api.endereco.configuration.exception;

public class InvalidParameterException extends RuntimeException {

	private final String parametro;
	private final String valor;

	private static final long serialVersionUID = 1L;

	public InvalidParameterException(String msg, String parametro, String valor) {
		super(msg);
		this.parametro = parametro;
		this.valor = valor;
	}

	public String getParametro() {
		return parametro;
	}

	public String getValor() {
		return valor;
	}



}
