package com.humanup.matrix.qcm.controllers;

import com.humanup.matrix.qcm.bs.AnswerBS;
import com.humanup.matrix.qcm.bs.QuestionBS;
import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import com.humanup.matrix.qcm.vo.QuestionVO;
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
    private QuestionBS questionBS;

    @Operation(summary = "Create Question",description = "Create new question by ",tags = { "question" })
    @RequestMapping(value = "/question", method= RequestMethod.POST,consumes = {"application/json"})
    @ResponseBody
    public ResponseEntity createQuestion(@RequestBody QuestionVO question){
        Optional<Object> findQuestion = Optional.ofNullable(questionBS.findQuestionByQuestionText(question.getQuestionText()));

        if(findQuestion.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("this question is founded");
        }

        questionBS.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(question);
    }

    @Operation(summary = "Find questions list", description = "Find all questions", tags = { "question" })
    @RequestMapping(value="/question/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findListQuestion(){
        List<QuestionVO> findQuestion= questionBS.findListQuestion();

        if(findQuestion.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findQuestion);
    }
}