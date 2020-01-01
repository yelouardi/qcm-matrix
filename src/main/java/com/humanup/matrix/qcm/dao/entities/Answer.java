package com.humanup.matrix.qcm.dao.entities;


import javax.persistence.*;

@Entity
public class Answer {
    private Choice choice;
    private String emailPerson;

    public Answer(Choice choice, String emailPerson) {
        this.choice = choice;
        this.emailPerson = emailPerson;
    }

    public Answer() {
    }

    public Choice getChoice() {
        return choice;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public static class Builder{
        private Choice choice;
        private String emailPerson;

        public Builder(){
        }

        public Answer.Builder setChoice(Choice choice){
            this.choice = choice;
            return this;
        }

        public Answer.Builder setEmailPerson(String emailPerson){
            this.emailPerson = emailPerson;
            return this;
        }
        public Answer build(){ return new Answer(choice, emailPerson);}
    }
}
