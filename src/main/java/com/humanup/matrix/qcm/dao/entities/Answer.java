package com.humanup.matrix.qcm.dao.entities;


import javax.persistence.*;

@Entity
public class Answer {
    private String choice;
    //private Person person;
    private String person;

    public Answer(String choice, String person) {
        this.choice = choice;
        this.person = person;
    }

    public Answer() {
    }

    public String getChoice() {
        return choice;
    }

    public String getPerson() {
        return person;
    }

    public static class Builder{
        private String choice;
        private String person;

        public Builder(){
        }

        public Answer.Builder setChoice(String choice){
            this.choice = choice;
            return this;
        }

        public Answer.Builder setPeron(String person){
            this.person = person;
            return this;
        }
        public Answer build(){ return new Answer(choice, person);}
    }
}
