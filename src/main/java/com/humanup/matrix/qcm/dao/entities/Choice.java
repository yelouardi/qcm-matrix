package com.humanup.matrix.qcm.dao.entities;

import javax.persistence.*;

@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long choiceId;
    private String choiceText;
    private int percentage;

    @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL, mappedBy = "choice")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public Choice() {
    }

    public Choice(String choiceText, int percentage,Question question,Answer answer) {
        this.choiceText = choiceText;
        this.percentage = percentage;
        this.question = question;
        this.answer = answer;
    }

    public Long getChoiceId() {
        return choiceId;
    }
    public String getChoiceText() {
        return choiceText;
    }
    public int getPercentage() { return percentage; }
    public Question getQuestion() { return question; }
    public Answer getAnswer() { return answer; }

    public static class Builder{
        private Long choiceId;
        private String choiceText;
        private int percentage;
        private Question question;
        private Answer answer;

        public Builder(){
        }

        public Builder setChoiceId(Long choiceId){
            this.choiceId = choiceId;
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

        public Builder setAnswer(Answer answer){
            this.answer = answer;
            return this;
        }

        public Choice build(){return new Choice(choiceText, percentage, question,answer);}
    }
}
