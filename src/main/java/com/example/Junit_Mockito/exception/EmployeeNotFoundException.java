package com.example.Junit_Mockito.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}
