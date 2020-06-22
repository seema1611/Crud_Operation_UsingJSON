package com.jsondemo.exception;

public class StudentException extends Throwable {
    public ExceptionType type;

    public enum ExceptionType {
        STUDENT_NOT_FOUND;
    }

    public StudentException(ExceptionType type) {
        this.type = type;
    }
}
