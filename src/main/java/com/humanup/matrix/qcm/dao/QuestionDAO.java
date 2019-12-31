package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionDAO extends CrudRepository {
    Question findByQuestion(String question);
    List<Question> findAll();
    Question findById(long id);
   // @Query("SELECT q FROM Question q WHERE lower() like %:question% ")
    // List<Question> findListProfilesByProfileTitle(String question);
}
