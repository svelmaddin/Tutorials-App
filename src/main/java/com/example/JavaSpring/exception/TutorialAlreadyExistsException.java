package com.example.JavaSpring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TutorialAlreadyExistsException extends RuntimeException{

    public TutorialAlreadyExistsException(String message) {
        super(message);
    }
}
