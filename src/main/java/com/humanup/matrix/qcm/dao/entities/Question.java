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
    private String question;

    public Question(String question) {
        this.question = question;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String question;

        public Builder(){
        }

        public Builder setQuestion(String question) {
            this.question = question;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Question build(){return new Question(question);}
    }

}
