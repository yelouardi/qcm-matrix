package com.humanup.matrix.qcm.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of= {"choiceId","choiceText","percentage"})
@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="choice_id")
     Long choiceId;
    @Column(name="choice_text")
     String choiceText;
    @Column(name="percentage")
     int percentage;

    @OneToOne(cascade =  CascadeType.ALL, mappedBy = "choice")
     Answer answer;

    @ManyToOne
    @JoinColumn(name = "questionId")
     Question question;

}
