package com.humanup.matrix.qcm.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = {"questionText", "questionId"})
public class QuestionVO {
  String questionText;
  @JsonIgnore Long questionId;
}
