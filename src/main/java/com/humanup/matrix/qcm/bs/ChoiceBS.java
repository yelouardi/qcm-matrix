package com.humanup.matrix.qcm.bs;

import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;
import com.humanup.matrix.qcm.vo.ChoiceVO;

import java.util.List;

public interface ChoiceBS {
    boolean createChoice(ChoiceVO choice);
    List<ChoiceVO> findListChoice();
    List<ChoiceVO> findChoiceByQuestionId(int questionId);
}
