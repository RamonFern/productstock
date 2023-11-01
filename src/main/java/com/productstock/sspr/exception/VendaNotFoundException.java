package com.productstock.sspr.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class VendaNotFoundException extends NotFoundException{//extends RuntimeException
	
	private static final long serialVersionUID = 1L;
	
	public VendaNotFoundException(Long id) {
		super();
	}

}

