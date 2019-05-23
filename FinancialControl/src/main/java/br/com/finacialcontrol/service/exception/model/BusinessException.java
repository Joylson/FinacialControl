package br.com.finacialcontrol.service.exception.model;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BusinessException (String msg){
		super(msg);
	}
	
	public BusinessException (String msg, Throwable th){
		super(msg, th);
	}

}
