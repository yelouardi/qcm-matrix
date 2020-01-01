package com.humanup.matrix.qcm.bs;

import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import com.humanup.matrix.qcm.vo.QuestionVO;

import java.util.List;

public interface QuestionBS {
    boolean createQuestion(QuestionVO question);
    List<QuestionVO> findListQuestion();
}
