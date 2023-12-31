package com.productstock.sspr.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends NotFoundException{ // RuntimeException
	
	private static final long serialVersionUID = 1L;
	
	public ProdutoNotFoundException(Long id) {
		super();
	}  

}
