package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Choice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChoiceDAO extends CrudRepository<Choice, Long> {
    Choice findByChoiceId(int choiceId);
    List<Choice> findAll();
    Choice findById(long id);
    @Query("SELECT c FROM Choice c WHERE lower(c.question.questionId) like %:questionId% ")
    List<Choice> findChoiceByQuestionId(int questionId);
}
