package com.backend.amedigital.handler;

import com.backend.amedigital.exceptions.PlanetNotFoundException;
import com.backend.amedigital.handler.responseHandler.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PlanetHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PlanetNotFoundException.class)
    private ResponseEntity<RestErrorMessage> categoriaNotFoundHandler(PlanetNotFoundException exception){
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

}
