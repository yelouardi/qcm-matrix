package com.humanup.matrix.qcm.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(of = {"choiceId", "choiceText", "percentage"})
@Entity
@Table(name = "choice")
public class Choice implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "choice_id")
  Long choiceId;

  @Column(name = "choice_text")
  String choiceText;

  @Column(name = "percentage")
  int percentage;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "choice")
  Answer answer;

  @ManyToOne
  @JoinColumn(name = "question_id")
  Question question;
}
