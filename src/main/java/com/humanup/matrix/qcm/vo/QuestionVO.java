package com.humanup.matrix.qcm.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class QuestionVO {
    private String questionText;
    @JsonIgnore
    private Long questionId;

    public QuestionVO(String questionText,Long questionId) {
        this.questionText = questionText;
        this.questionId = questionId;
    }

    public QuestionVO() {
    }

    public String getQuestionText() {
        return questionText;
    }
    public Long getQuestionId() {
        return questionId;
    }

public static class Builder{
        private String questionText;
        @JsonIgnore
        private Long questionId;

        public Builder(){
        }

    public Builder setQuestionText(String questionText) {
        this.questionText = questionText;
        return this;
    }

    public Builder setQuestionId(Long questionId) {
        this.questionId = questionId;
        return this;
    }
    public QuestionVO build(){return new QuestionVO(questionText,questionId);}
}
}
