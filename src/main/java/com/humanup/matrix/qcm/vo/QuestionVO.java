package com.humanup.matrix.qcm.vo;

public class QuestionVO {
    private String questionText;

    public QuestionVO(String questionText) {
        this.questionText = questionText;
    }

    public QuestionVO() {
    }

    public String getQuestionText() {
        return questionText;
    }

public static class Builder{
        private String questionText;

        public Builder(){
        }

    public Builder setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }
    public QuestionVO build(){return new QuestionVO(questionText);}
}
}
