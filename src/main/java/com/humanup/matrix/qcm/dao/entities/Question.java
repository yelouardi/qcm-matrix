package com.humanup.matrix.qcm.dao.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"questionId", "questionText", "choiceList"})
@Entity
@Table(name = "question")
public class Question implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_id")
  Long questionId;

  @Column(name = "question_text")
  String questionText;

  @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
  List<Choice> choiceList;
}
