package com.example.JavaSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TutorialNotNullException.class)
    public ResponseEntity<?> tutorialNotNull(TutorialNotNullException notNullException) {
        List<String> detail = new ArrayList<>();
        detail.add(notNullException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Tutorial not null!", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TutorialNotFoundException.class)
    public ResponseEntity<?> tutorialNotfound(TutorialNotFoundException notFoundException) {
        List<String> detail = new ArrayList<>();
        detail.add(notFoundException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Tutorial not found!", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TutorialAlreadyExistsException.class)
    public ResponseEntity<?> tutorialNotfound(TutorialAlreadyExistsException tutorialAlreadyExistsException) {
        List<String> detail = new ArrayList<>();
        detail.add(tutorialAlreadyExistsException.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Tutorial already exists!", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileUploadExceptionAdvice.class)
    public ResponseEntity<?> fileSize(FileUploadExceptionAdvice fileUploadExceptionAdvice) {
        List<String> detail = new ArrayList<>();
        detail.add(fileUploadExceptionAdvice.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(".......", detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
