package com.cepapi.exception;

import java.io.Serializable;
import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CepNotFound extends RuntimeException{
	private static final long serialVersionUID = 1071464351981156149L;

	public CepNotFound(String msg) {
		super(msg);
	}
	
	public static <T extends Serializable> Supplier<CepNotFound> notFound(final T notFound) {
	    return () -> new CepNotFound("Error: "+ notFound);
	}
}
