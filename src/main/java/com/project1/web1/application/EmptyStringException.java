package com.project1.web1.application;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException() {
        super("String is empty");
    }
}
