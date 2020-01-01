package com.humanup.matrix.qcm.bs;

import com.humanup.matrix.qcm.exceptions.AnswerException;
import com.humanup.matrix.qcm.vo.AnswerVO;

import java.util.List;

public interface AnswerBS {
    boolean createAnswer(AnswerVO answer) throws AnswerException;
    List <AnswerVO> findListAnswer();
    List<AnswerVO> findListAnswerByEmailPerson(String emailPerson);
}
