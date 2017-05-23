package com.uniara.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção ultilizada para tratar recursos não cadastrados no sistema.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Cotação não encontrada")
public class NotFoundException extends Exception{
}
