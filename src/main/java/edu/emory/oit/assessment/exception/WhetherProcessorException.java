package edu.emory.oit.assessment.exception;

public class WhetherProcessorException extends RuntimeException {
    private String message;

    public WhetherProcessorException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
