package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Answer;

import java.util.List;

public interface AnswerDAO{
    Answer findByAnswer(String answer);
    List<Answer> findAll();
    Answer findById(long id);
    // @Query("SELECT q FROM Answer q WHERE lower() like %:Answer% ")
    // List<Answer> findListProfilesByProfileTitle(String Answer);
}
