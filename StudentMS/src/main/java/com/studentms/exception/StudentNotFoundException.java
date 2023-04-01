package com.studentms.exception;

public class StudentNotFoundException extends RuntimeException {


    public StudentNotFoundException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}