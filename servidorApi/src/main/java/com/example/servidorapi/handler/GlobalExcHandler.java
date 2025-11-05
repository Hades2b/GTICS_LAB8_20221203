package com.example.servidorapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@ControllerAdvice
public class GlobalExcHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> responseBody = Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Parámetro inválido: "+ex.getValue()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

}
