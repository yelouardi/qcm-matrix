package com.humanup.matrix.qcm.bs.impl;

import com.humanup.matrix.qcm.bs.QuestionBS;
import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class QuestionBSImpl implements QuestionBS {

    @Autowired
    private QuestionDAO questionDAO;

    @Override
    public boolean createQuestion(QuestionVO questionVO) {
        Question questionToSave =new Question.Builder()
                .setQuestionText(questionVO.getQuestionText())
                .build();
        return  questionDAO.save(questionToSave)!=null;
    }

    @Override
    public List<QuestionVO> findListQuestion() {
        return questionDAO.findAll()
                .stream()
                .map(questionFinded -> new QuestionVO.Builder()
                        .setQuestionText(questionFinded.getQuestionText())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public QuestionVO findQuestionById(Long questionId) {
        Optional<Question> questionFinded = Optional.ofNullable(questionDAO.findQuestionByQuestionId(questionId));
        if(questionFinded.isPresent()) {
            return new QuestionVO.Builder()
                    .setQuestionText(questionFinded.get().getQuestionText())
                    .setQuestionId(questionFinded.get().getQuestionId())
                    .build();
        }
        return null;
    }

}
