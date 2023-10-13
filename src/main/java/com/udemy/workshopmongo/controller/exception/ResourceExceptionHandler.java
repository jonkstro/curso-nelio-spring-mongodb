package com.udemy.workshopmongo.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// Intercepta as exceções para tratamento personalizado delas
@ControllerAdvice
public class ResourceExceptionHandler {

    // Tratamento personalizado da exceção ObjectNotFoundException
    // Anotation para interceptar a requisição que deu exceção
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        String msgErro = "Objeto não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), msgErro, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}