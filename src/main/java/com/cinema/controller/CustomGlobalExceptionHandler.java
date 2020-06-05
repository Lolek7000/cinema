package com.cinema.controller;

import com.cinema.exceptions.ObjectAlreadyExistsException;
import com.cinema.exceptions.ObjectNotFoundException;
import com.cinema.exceptions.ScreeningRoomAlreadyTakenException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {

        List<String> messages = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            messages.add(constraintViolation.getMessage());
        }
        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    protected ResponseEntity<String> handleObjectNotFoundException(ObjectNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    protected ResponseEntity<String> handleObjectAlreadyExistsException(ObjectAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<String> handleSQLIntegrityConstraintViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(ex.getMostSpecificCause().getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ScreeningRoomAlreadyTakenException.class)
    protected ResponseEntity<String> handleScreeningRoomAlreadyTakenException(ScreeningRoomAlreadyTakenException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Object> errorList = new ArrayList<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorList.add(fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}

