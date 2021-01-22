package com.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(NotFoundException exc){

        ExceptionResponse response = new ExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DateNotFreeException.class)
    public ResponseEntity<ExceptionResponse> handleException(DateNotFreeException exc){

        ExceptionResponse response = new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidIdOrPinException.class)
    public ResponseEntity<ExceptionResponse> handleException(InvalidIdOrPinException exc){

        ExceptionResponse response = new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exc){

        ExceptionResponse response = new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getBindingResult().getFieldError().getDefaultMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exc){

        ExceptionResponse response = new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Something went wrong. Probably you passed invalid data please check it and try again or contact us via email.",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

}
