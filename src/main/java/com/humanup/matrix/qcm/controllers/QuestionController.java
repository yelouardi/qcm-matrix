package com.humanup.matrix.qcm.controllers;

import com.humanup.matrix.qcm.bs.AnswerBS;
import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private AnswerBS answerBS;

    @Operation(summary = "Create Answer",description = "Create new answer by ",tags = { "answer" })
    @RequestMapping(value = "/answer", method= RequestMethod.POST,consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity createAnswer(@RequestBody AnswerVO answer) throws AnswerException {
        Optional<Object> findAnswer = Optional.ofNullable(answerBS.findAnswerByEmailPersonAndChoice(answer.getEmailPerson(),answer.getChoiceId()));

        if(findAnswer.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("this answer is founded");
        }

        answerBS.createAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(answer);
    }

    @Operation(summary = "Find all answer", description = "Find all answers", tags = { "answer" })
    @RequestMapping(value="/answer/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllAnswerInfo(){
        List<AnswerVO> findAnswer= answerBS.findListAnswer();

        if(findAnswer.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAnswer);
    }

    @Operation(summary = "Find all answers by person", description = "Find all answer by person emailAdress", tags = { "answer" })
    @RequestMapping(value="/answer/all/person", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAnswerPerson(@RequestParam(value="emailAddress", defaultValue="khalil@gmail.com") String emailAddress){
        Optional<List<AnswerVO>> findAnswer = Optional.ofNullable(answerBS.findListAnswerByEmailPerson(emailAddress));
        if(findAnswer.get().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This emailAddress not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAnswer.get());
    }
}
