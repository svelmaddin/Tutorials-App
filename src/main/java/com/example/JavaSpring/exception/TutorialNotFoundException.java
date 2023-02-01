package com.example.JavaSpring.exception;

public class TutorialNotFoundException extends RuntimeException{

    public TutorialNotFoundException(String message) {
        super(message);
    }
}
