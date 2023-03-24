package com.addname.demo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNoFoundException extends RuntimeException {

    private static final long serialVersionID = 1L;

    public  ResourceNoFoundException(String mensaje){
        super(mensaje);
    }
}
