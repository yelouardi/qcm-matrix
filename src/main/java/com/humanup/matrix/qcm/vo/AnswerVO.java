package com.humanup.matrix.qcm.vo;

public class AnswerVO {
    private Long choiceId;
    private String emailPerson;

    public AnswerVO(Long choiceId, String emailPerson) {
        this.choiceId = choiceId;
        this.emailPerson = emailPerson;
    }

    public AnswerVO() {
    }

    public Long getChoiceId() {
        return choiceId;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public static class Builder{
        private Long choiceId;
        private String emailPerson;

        public Builder(){
        }

        public Builder setchoiceId( Long choiceId){
            this.choiceId = choiceId;
            return this;
        }

        public Builder setEmailPerson(String emailPerson){
            this.emailPerson = emailPerson;
            return this;
        }
        public AnswerVO build(){ return new AnswerVO(choiceId, emailPerson);}
    }

}
