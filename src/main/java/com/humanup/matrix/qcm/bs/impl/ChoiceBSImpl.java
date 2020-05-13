package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.ChoiceBS;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.ChoiceVO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ChoiceBSImpl implements ChoiceBS {

  @Autowired private ChoiceDAO choiceDAO;

  @Autowired private QuestionDAO questionDAO;

  @Override
  public boolean createChoice(ChoiceVO choiceVO) {
    Question question = questionDAO.findQuestionByQuestionId(choiceVO.getQuestionId());
    Choice choiceToSave =
        Choice.builder()
            .choiceText(choiceVO.getChoiceText())
            .percentage(choiceVO.getPercentage())
            .question(question)
            .build();
    return choiceDAO.save(choiceToSave) != null;
  }

  @Override
  public List<ChoiceVO> findListChoice() {
    return choiceDAO.findAll().stream()
        .map(
            choiceFinded ->
                ChoiceVO.builder()
                    .choiceText(choiceFinded.getChoiceText())
                    .percentage(choiceFinded.getPercentage())
                    .questionId(choiceFinded.getQuestion().getQuestionId())
                    .build())
        .collect(Collectors.toList());
  }

  @Override
  public List<ChoiceVO> findChoiceByQuestionId(Long questionId) {
    return choiceDAO.findChoiceByQuestionId(questionId).stream()
        .map(
            choiceFinded ->
                ChoiceVO.builder()
                    .choiceText(choiceFinded.getChoiceText())
                    .percentage(choiceFinded.getPercentage())
                    .questionId(choiceFinded.getQuestion().getQuestionId())
                    .build())
        .collect(Collectors.toList());
  }

  @Override
  public ChoiceVO findChoiceByChoiceId(Long choiceId) {
    Optional<Choice> choiceFinded = Optional.ofNullable(choiceDAO.findChoiceByChoiceId(choiceId));
    if (choiceFinded.isPresent()) {
      return ChoiceVO.builder()
          .choiceText(choiceFinded.get().getChoiceText())
          .percentage(choiceFinded.get().getPercentage())
          .questionId(choiceFinded.get().getQuestion().getQuestionId())
          .build();
    }
    return null;
  }
}
