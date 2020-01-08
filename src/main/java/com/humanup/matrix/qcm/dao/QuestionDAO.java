package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends CrudRepository<Question, Long>  {
    Question findQuestionByQuestionId(Long questionId);
    List<Question> findAll();
    Question findQuestionByQuestionText(String questionText);
}
