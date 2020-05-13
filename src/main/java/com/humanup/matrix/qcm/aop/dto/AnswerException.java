package com.humanup.matrix.qcm.aop.dto;

public class AnswerException extends HttpException {
  public AnswerException(String message) {
    super(message);
  }

  public AnswerException() {
    super();
  }

  @Override
  public String getMessage() {
    return "Cannot Create Answer";
  }
}
