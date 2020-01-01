package com.humanup.matrix.qcm.dao.entities;

import javax.persistence.*;

public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String choiceText;
    private int percentage;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Choice() {
    }

    public Choice(String choiceText, int percentage,Question question) {
        this.choiceText = choiceText;
        this.percentage = percentage;
        this.question = question;
    }

    public Long getId() {
        return id;
    }
    public String getChoiceText() {
        return choiceText;
    }
    public int getPercentage() { return percentage; }
    public Question getQuestion() { return question; }

    public static class Builder{
        private Long id;
        private String choiceText;
        private int percentage;
        private Question question;

        public Builder(){
        }

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder setChoiceText(String choiceText){
            this.choiceText = choiceText;
            return this;
        }

        public Builder setPercentage(int percentage){
            this.percentage = percentage;
            return this;
        }

        public Builder setQuestion(Question question){
            this.question = question;
            return this;
        }

        public Choice build(){return new Choice(choiceText, percentage, question);}
    }
}
