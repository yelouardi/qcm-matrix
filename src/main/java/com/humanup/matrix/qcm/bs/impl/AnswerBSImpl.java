package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.AnswerBS;
import com.humanup.matrix.qcm.dao.AnswerDAO;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.entities.Answer;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AnswerBSImpl implements AnswerBS {

    @Autowired
    private AnswerDAO answerDAO;

    @Autowired
    private ChoiceDAO choiceDAO;

    @Override
    public boolean createAnswer(AnswerVO answerVO) throws AnswerException {
        Choice Choice = choiceDAO.findByChoiceText(answerVO.getChoiceText());
        Answer answerToSave =new Answer.Builder()
                .setChoice(Choice)
                .setEmailPerson(answerVO.getEmailPerson())
                .build();
        return  answerDAO.save(answerToSave)!=null;
    }

    @Override
    public List<AnswerVO> findListAnswer() {
        return answerDAO.findAll()
                .stream()
                .map(answerFinded -> new AnswerVO.Builder()
                        .setchoiceText(answerFinded.getChoice().getChoiceText())
                        .setPerson(answerFinded.getEmailPerson())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<AnswerVO> findListAnswerByEmailPerson(String firstName) {
        return answerDAO.findListAnswerByEmailPerson(firstName)
                .stream()
                .map(answerFinded -> new AnswerVO.Builder()
                        .setchoiceText(answerFinded.getChoice().getChoiceText())
                        .setPerson(answerFinded.getEmailPerson())
                        .build())
                .collect(Collectors.toList());
    }
}
