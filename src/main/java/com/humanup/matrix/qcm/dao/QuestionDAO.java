package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Answer;
import com.humanup.matrix.qcm.dao.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDAO extends CrudRepository<Question, Long>  {
    Question findQuestionByQuestionId(Long questionId);
    List<Question> findAll();
    Question findById(long id);
}
