package com.humanup.matrix.qcm.aop.dto;

public class ChoiceException extends HttpException {
    public ChoiceException(String message) {
        super(message);
    }

    public ChoiceException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Cannot Create Choice";
    }
}
