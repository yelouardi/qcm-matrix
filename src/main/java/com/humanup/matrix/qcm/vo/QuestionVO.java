package com.humanup.matrix.qcm.vo;

public class QuestionVO {
    private String question;

    public QuestionVO(String question) {
        this.question = question;
    }

    public QuestionVO() {
    }

    public String getQuestion() {
        return question;
    }

public static class Builder{
        private String question;

        public Builder(){
        }

    public Builder setQuestion(String question) {
        this.question = question;
        return this;
    }
    public QuestionVO build(){return new QuestionVO(question);}
}
}
