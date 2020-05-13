package com.humanup.matrix.qcm.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = {"choiceId", "emailPerson"})
public class AnswerVO {

  Long choiceId;
  String emailPerson;
}
