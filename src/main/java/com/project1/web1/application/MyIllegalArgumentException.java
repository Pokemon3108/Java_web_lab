package com.project1.web1.application;

public class MyIllegalArgumentException extends IllegalArgumentException {
    public MyIllegalArgumentException() {
        super("Illegal string");
    }
}
