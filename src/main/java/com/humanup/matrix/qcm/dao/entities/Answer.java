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
@ToString(of= {"answerId","emailPerson"})
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="answer_id")
     Long answerId;
    @Column(name="email_person")
     String emailPerson;

    @OneToOne(optional = false)
    @JoinColumn(name = "choiceId", nullable = false)
     Choice choice;
}
