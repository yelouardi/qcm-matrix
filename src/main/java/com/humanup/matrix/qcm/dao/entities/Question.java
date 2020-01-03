package com.humanup.matrix.qcm.dao.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String questionText;

    @OneToMany(mappedBy="question",fetch=FetchType.LAZY)
    private List<Choice> choiceList;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Question() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public static class Builder{
        private Long questionId;
        private String questionText;

        public Builder(){
        }

        public Builder setQuestionText(String questionText) {
            this.questionText = questionText;
            return this;
        }

        public Builder setQuestionId(Long questionId) {
            this.questionId = questionId;
            return this;
        }

        public Question build(){return new Question(questionText);}
    }

}
