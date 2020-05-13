package com.humanup.matrix.qcm.aop.dto;

public class QuestionException extends HttpException {
  public QuestionException(String message) {
    super(message);
  }

  public QuestionException() {
    super();
  }

  @Override
  public String getMessage() {
    return "Cannot Create Question";
  }
}
