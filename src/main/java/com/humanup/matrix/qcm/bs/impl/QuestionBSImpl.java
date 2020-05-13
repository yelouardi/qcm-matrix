package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.QuestionBS;
import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.QuestionVO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class QuestionBSImpl implements QuestionBS {

  @Autowired private QuestionDAO questionDAO;

  @Override
  public boolean createQuestion(QuestionVO questionVO) {
    Question questionToSave = Question.builder().questionText(questionVO.getQuestionText()).build();
    return questionDAO.save(questionToSave) != null;
  }

  @Override
  public List<QuestionVO> findListQuestion() {
    return questionDAO.findAll().stream()
        .map(
            questionFinded ->
                QuestionVO.builder().questionText(questionFinded.getQuestionText()).build())
        .collect(Collectors.toList());
  }

  @Override
  public QuestionVO findQuestionById(Long questionId) {
    Optional<Question> questionFinded =
        Optional.ofNullable(questionDAO.findQuestionByQuestionId(questionId));
    if (questionFinded.isPresent()) {
      return QuestionVO.builder()
          .questionText(questionFinded.get().getQuestionText())
          .questionId(questionFinded.get().getQuestionId())
          .build();
    }
    return null;
  }

  @Override
  public QuestionVO findQuestionByQuestionText(String questionText) {
    Optional<Question> questionFinded =
        Optional.ofNullable(questionDAO.findQuestionByQuestionText(questionText));
    if (questionFinded.isPresent()) {
      return QuestionVO.builder()
          .questionText(questionFinded.get().getQuestionText())
          .questionId(questionFinded.get().getQuestionId())
          .build();
    }
    return null;
  }
}
