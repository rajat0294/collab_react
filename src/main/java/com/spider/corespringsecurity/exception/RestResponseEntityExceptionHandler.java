package com.spider.corespringsecurity.exception;

import com.spider.corespringsecurity.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleConflict(
            MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(ErrorDto.builder().msg(ex.getMessage()).code(1000).build(),HttpStatus.BAD_REQUEST);
    }
}

