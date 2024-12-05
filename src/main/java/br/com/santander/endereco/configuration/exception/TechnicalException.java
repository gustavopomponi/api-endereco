/**
 *
 */
package br.com.santander.endereco.configuration.exception;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 981283912L;

	public TechnicalException(String msg) {
		super(msg);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}


}
