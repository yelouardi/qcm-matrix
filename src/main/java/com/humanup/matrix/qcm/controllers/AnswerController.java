package com.humanup.matrix.qcm.controllers;

import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import com.humanup.matrix.qcm.bs.AnswerBS;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AnswerController {
    @Autowired
    private AnswerBS answerBS;

    @Operation(summary = "Create Answer",description = "Create new answer by ",tags = { "answer" })
    @RequestMapping(value = "/answer", method= RequestMethod.POST,consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity createAnswer(@RequestBody AnswerVO answer){
        Optional<Object> findAnswer = Optional.ofNullable(answerBS.findAnswerByChoice(answer.getChoice()));

        if(findAnswer.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("this answer is founded");
        }
      //  answerBS.createAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(answer);
    }

    @Operation(summary="Create Answer", description ="", tags = {"person"})
    @RequestMapping(value ="answer/person", method=RequestMethod.POST,consumes={ "application/json"})
    @ResponseBody
    public ResponseEntity addPersonAnswer(@RequestParam(value="choice", defaultValue = "aa") String answer) throws AnswerException{

    }

}
