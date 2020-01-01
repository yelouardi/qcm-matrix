package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerDAO extends CrudRepository<Answer, Long> {
    Answer findAnswerByEmailPersonAndChoiceId(String emailPerson, int choiceId);
    List<Answer> findAll();
    Answer findById(long id);
    @Query("SELECT a FROM Answer a WHERE lower(a.emailPerson) like %:emailPerson% ")
    List<Answer> findListAnswerByEmailPerson(String emailPerson);
}
