package com.humanup.matrix.qcm.bs;

import com.humanup.matrix.qcm.aop.dto.QuestionException;
import com.humanup.matrix.qcm.vo.QuestionVO;
import java.util.List;

public interface QuestionBS {
    boolean createQuestion(QuestionVO question) throws QuestionException;

    List<QuestionVO> findListQuestion();

    QuestionVO findQuestionById(Long questionId);

    QuestionVO findQuestionByQuestionText(String questionText);
}