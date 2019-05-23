package br.com.finacialcontrol.resource.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ValidationError extends StandardError{
	
	private static final long serialVersionUID = 1L;

	@Getter
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Long timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}
}
