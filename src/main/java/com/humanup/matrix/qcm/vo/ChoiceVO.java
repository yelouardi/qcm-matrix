package com.humanup.matrix.qcm.vo;

public class ChoiceVO {
    private String choice;
    private int percentage;
    private String question;

    public ChoiceVO() {
    }

    public ChoiceVO(String choice, int percentage, String question) {
        this.choice = choice;
        this.percentage = percentage;
        this.question = question;
    }

    public String getChoice() {
        return choice;
    }
    public int getPercentage(){return percentage;}
    public String getQuestion(){return question;}

    public static class Builder {
        private String choice;
        private int percentage;
        private String question;

        public Builder() {
        }

        public Builder setChoice(String choice) {
            this.choice = choice;
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
            return new ChoiceVO(choice, percentage,question);
        }
    }
}

