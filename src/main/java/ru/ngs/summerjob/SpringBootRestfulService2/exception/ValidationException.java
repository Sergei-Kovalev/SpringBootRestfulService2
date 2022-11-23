package ru.ngs.summerjob.SpringBootRestfulService2.exception;

public class ValidationException extends Exception {
    private String message;

    public ValidationException(String message) {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
