package com.stickynotes.sticky.note.controller;

import com.stickynotes.sticky.note.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Response> handleAccessDeniedException(AccessDeniedException ex) {
        // Customize the response here
        return new ResponseEntity<>(new Response("You do not have permission to access this resource.", null, false), HttpStatus.FORBIDDEN);
    }

    // Other exception handlers can be added here
}