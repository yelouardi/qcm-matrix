package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.AnswerBS;
import com.humanup.matrix.qcm.dao.AnswerDAO;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.entities.Answer;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AnswerBSImpl implements AnswerBS {

  @Autowired private AnswerDAO answerDAO;

  @Autowired private ChoiceDAO choiceDAO;

  @Override
  public boolean createAnswer(AnswerVO answerVO) throws AnswerException {
    Choice Choice = choiceDAO.findByChoiceId(answerVO.getChoiceId());
    Answer answerToSave =
        Answer.builder().choice(Choice).emailPerson(answerVO.getEmailPerson()).build();
    return answerDAO.save(answerToSave) != null;
  }

  @Override
  public List<AnswerVO> findListAnswer() {
    return answerDAO.findAll().stream()
        .map(
            answerFinded ->
                AnswerVO.builder()
                    .choiceId(answerFinded.getChoice().getChoiceId())
                    .emailPerson(answerFinded.getEmailPerson())
                    .build())
        .collect(Collectors.toList());
  }

  @Override
  public List<AnswerVO> findListAnswerByEmailPerson(String firstName) {
    return answerDAO.findListAnswerByEmailPerson(firstName).stream()
        .map(
            answerFinded ->
                AnswerVO.builder()
                    .choiceId(answerFinded.getChoice().getChoiceId())
                    .emailPerson(answerFinded.getEmailPerson())
                    .build())
        .collect(Collectors.toList());
  }

  @Override
  public AnswerVO findAnswerByEmailPersonAndChoice(String emailPerson, Long choiceId) {
    Optional<Answer> answerFinded =
        Optional.ofNullable(answerDAO.findAnswerByEmailPersonAndChoice(emailPerson, choiceId));
    if (answerFinded.isPresent()) {
      return AnswerVO.builder()
          .choiceId(answerFinded.get().getChoice().getChoiceId())
          .emailPerson(answerFinded.get().getEmailPerson())
          .build();
    }
    return null;
  }
}
