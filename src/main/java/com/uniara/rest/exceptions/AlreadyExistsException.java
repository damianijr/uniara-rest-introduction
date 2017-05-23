package com.uniara.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção ultilizada para evitar duplicidade no sistema.
 */
@ResponseStatus(value=HttpStatus.CONFLICT,reason="Essa cotação já está cadastrada no sistema")
public class AlreadyExistsException extends Exception{
}
