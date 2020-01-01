package com.humanup.matrix.qcm.dao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Question() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String questionText;

        public Builder(){
        }

        public Builder setQuestionText(String questionText) {
            this.questionText = questionText;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Question build(){return new Question(questionText);}
    }

}
