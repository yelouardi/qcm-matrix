package com.humanup.matrix.qcm.dao.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of= {"questionId","questionText","choiceList"})
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
     Long questionId;
    @Column(name="question_text")
     String questionText;

    @OneToMany(mappedBy="question",fetch=FetchType.LAZY)
     List<Choice> choiceList;
}
