package com.humanup.matrix.qcm.vo;

public class ChoiceVO {
    private String choiceText;
    private int percentage;
    private Long questionId;

    public ChoiceVO() {
    }

    public ChoiceVO(String choiceText, int percentage, Long questionId) {
        this.choiceText = choiceText;
        this.percentage = percentage;
        this.questionId = questionId;
    }

    public String getChoiceText() {
        return choiceText;
    }
    public int getPercentage(){return percentage;}
    public Long getQuestionId(){return questionId;}

    public static class Builder {
        private String choiceText;
        private int percentage;
        private Long questionId;

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
        public Builder setQuestionId(Long questionId){
            this.questionId = questionId;
            return this;
        }

        public ChoiceVO build() {
            return new ChoiceVO(choiceText, percentage,questionId);
        }
    }
}

