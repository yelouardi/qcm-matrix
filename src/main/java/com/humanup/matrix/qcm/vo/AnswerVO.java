package com.humanup.matrix.qcm.vo;

public class AnswerVO {
    private String choice;
    private String person;

    public AnswerVO(String choice, String person) {
        this.choice = choice;
        this.person = person;
    }

    public AnswerVO() {
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

        public Builder setChoice( String choice){
            this.choice = choice;
            return this;
        }

        public Builder setPeron(String person){
            this.person = person;
            return this;
        }
        public AnswerVO build(){ return new AnswerVO(choice, person);}
    }

}
