/**
 *
 */
package br.com.api.endereco.configuration.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EnderecoNaoEncontradoException.class)
	public ResponseEntity<Object> handleEnderecoNaoEncontradoException(EnderecoNaoEncontradoException ex, WebRequest request){

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now().toString());
		body.put("message", "Endereco nao encontrado !!");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Parâmetro Invalido !!");

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleConstraintViolationException(NoSuchElementException ex, WebRequest request){

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Endereço não existente !!");

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

	}


}
