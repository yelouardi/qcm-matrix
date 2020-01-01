package com.humanup.matrix.qcm.vo;

public class ChoiceVO {
    private String choiceText;
    private int percentage;
    private String question;

    public ChoiceVO() {
    }

    public ChoiceVO(String choiceText, int percentage, String question) {
        this.choiceText = choiceText;
        this.percentage = percentage;
        this.question = question;
    }

    public String getChoiceText() {
        return choiceText;
    }
    public int getPercentage(){return percentage;}
    public String getQuestion(){return question;}

    public static class Builder {
        private String choiceText;
        private int percentage;
        private String question;

        public Builder() {
        }

        public Builder setChoiceText(String choiceText) {
            this.choiceText = choiceText;
            return this;
        }
        public Builder setPercentage(int percentage){
            this.percentage = percentage;
            return this;
        }
        public Builder setQuestion(String question){
            this.question = question;
            return this;
        }

        public ChoiceVO build() {
            return new ChoiceVO(choiceText, percentage,question);
        }
    }
}

