package com.humanup.matrix.qcm.dao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String choice;
    private String percentage;

    public Choice() {
    }

    public Choice(String choice, String percentage) {
        this.choice = choice;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }
    public String getChoice() {
        return choice;
    }
    public String getpercentage() { return percentage; }

    public static class Builder{
        private Long id;
        private String choice;
        private String percentage;

        public Builder(){
        }

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder setChoice(String choice){
            this.choice = choice;
            return this;
        }

        public Builder setPercentage(String percentage){
            this.percentage = percentage;
            return this;
        }

        public Choice build(){return new Choice(choice, percentage);}
    }
}
