package com.humanup.matrix.qcm.vo;

public class AnswerVO {
    private String choiceText;
    private String emailPerson;

    public AnswerVO(String choiceText, String emailPerson) {
        this.choiceText = choiceText;
        this.emailPerson = emailPerson;
    }

    public AnswerVO() {
    }

    public String getChoiceText() {
        return choiceText;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public static class Builder{
        private String choiceText;
        private String emailPerson;

        public Builder(){
        }

        public Builder setchoiceText( String choiceText){
            this.choiceText = choiceText;
            return this;
        }

        public Builder setPerson(String emailPerson){
            this.emailPerson = emailPerson;
            return this;
        }
        public AnswerVO build(){ return new AnswerVO(choiceText, emailPerson);}
    }

}
