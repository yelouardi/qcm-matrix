package com.humanup.matrix.qcm.controllers;

import com.humanup.matrix.qcm.bs.ChoiceBS;
import com.humanup.matrix.qcm.vo.ChoiceVO;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChoiceController {

  @Autowired private ChoiceBS choiceBS;

  @Operation(
      summary = "Create Choice",
      description = "Create choice answer by ",
      tags = {"choice"})
  @RequestMapping(
      value = "/choice",
      method = RequestMethod.POST,
      consumes = {"application/json"})
  @ResponseBody
  public ResponseEntity createChoice(@RequestBody ChoiceVO choice) {
    // Optional<Object> findChoice =
    // Optional.ofNullable(choiceBS.findChoiceByQuestionId(choice.getQuestionId()));
    List<ChoiceVO> lstChoices = choiceBS.findChoiceByQuestionId(choice.getQuestionId());

    if (lstChoices.size() == 4) {
      return ResponseEntity.status(HttpStatus.FOUND)
          .body("this question ID " + choice.getQuestionId() + " can't have more four choices");
    }

    choiceBS.createChoice(choice);
    return ResponseEntity.status(HttpStatus.CREATED).body(choice);
  }

  @Operation(
      summary = "Find all choice",
      description = "Find all choice",
      tags = {"choice"})
  @RequestMapping(value = "/choice/all", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getAllChoiceInfo() {
    List<ChoiceVO> findChoice = choiceBS.findListChoice();

    if (findChoice.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(findChoice);
  }

  @Operation(
      summary = "Find all choice by question Id",
      description = "Find all choice by question Id",
      tags = {"choice"})
  @RequestMapping(value = "/choice/all/question", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getChoicesByQuestionId(
      @RequestParam(value = "questionId", defaultValue = "1") Long questionId) {
    Optional<List<ChoiceVO>> findChoices =
        Optional.ofNullable(choiceBS.findChoiceByQuestionId(questionId));

    if (findChoices.get().isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(findChoices);
  }

  @Operation(
      summary = "Find choice by choice Id",
      description = "Find choice by choice Id",
      tags = {"choice"})
  @RequestMapping(value = "/choice/all/choiceId", method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity getChoicesByChoiceId(
      @RequestParam(value = "choiceId", defaultValue = "1") Long choiceId) {
    Optional<ChoiceVO> findChoices = Optional.ofNullable(choiceBS.findChoiceByChoiceId(choiceId));

    if (findChoices.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(findChoices);
  }
}
