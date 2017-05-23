package com.uniara.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by carlos.ribeiro on 5/22/17.
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Cotação não encontrada")
public class NotFoundException extends Exception{
}
