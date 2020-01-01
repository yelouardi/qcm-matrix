package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.ChoiceBS;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.ChoiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ChoiceBSImpl implements ChoiceBS {

    @Autowired
    private ChoiceDAO choiceDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public boolean createChoice(ChoiceVO choiceVO) {
        Question question = questionDAO.findByQuestionText(choiceVO.getQuestion());
        Choice choiceToSave =new Choice.Builder()
                .setChoiceText(choiceVO.getChoiceText())
                .setPercentage(choiceVO.getPercentage())
                .setQuestion(question)
                .build();
        return  choiceDAO.save(choiceToSave)!=null;
    }

    @Override
    public List<ChoiceVO> findListChoice() {
        return choiceDAO.findAll()
                .stream()
                .map(choiceFinded -> new ChoiceVO.Builder()
                        .setChoiceText(choiceFinded.getChoiceText())
                        .setPercentage(choiceFinded.getPercentage())
                        .setQuestion(choiceFinded.getQuestion().getQuestionText())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ChoiceVO> findChoiceByQuestionId(int questionId) {
        return choiceDAO.findChoiceByQuestionId(questionId)
                .stream()
                .map(choiceFinded -> new ChoiceVO.Builder()
                        .setChoiceText(choiceFinded.getChoiceText())
                        .setPercentage(choiceFinded.getPercentage())
                        .setQuestion(choiceFinded.getQuestion().getQuestionText())
                        .build())
                .collect(Collectors.toList());
    }
}
