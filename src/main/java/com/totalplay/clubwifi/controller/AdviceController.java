package com.totalplay.clubwifi.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> readableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        HashMap<String, String> result = new LinkedHashMap<>();
        HashMap<String, Object> response = new LinkedHashMap<>();

        result.put("code", "-50");
        result.put("description", "Solicitud incorrecta.");
        response.put("result", result);

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

}
