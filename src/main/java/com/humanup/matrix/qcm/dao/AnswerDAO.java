package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerDAO extends CrudRepository<Answer, Long> {

    @Query("SELECT a FROM Answer a WHERE lower(a.emailPerson) = :emailPerson and a.choice.choiceId = :choiceId ")
    Answer findAnswerByEmailPersonAndChoice(String emailPerson, Long choiceId);
    List<Answer> findAll();
    //Answer findById(Long id);
    @Query("SELECT a FROM Answer a WHERE lower(a.emailPerson) like %:emailPerson% ")
    List<Answer> findListAnswerByEmailPerson(String emailPerson);
}
