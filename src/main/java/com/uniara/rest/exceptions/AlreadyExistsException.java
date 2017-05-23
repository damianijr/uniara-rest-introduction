package com.uniara.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by carlos.ribeiro on 5/22/17.
 */
@ResponseStatus(value= HttpStatus.CONFLICT,reason="Essa cotação já está cadastrada no sistema")
public class AlreadyExistsException extends Exception{
}
