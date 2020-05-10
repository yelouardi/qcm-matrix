package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Choice;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceDAO extends CrudRepository<Choice, Long> {
  Choice findByChoiceId(Long choiceId);

  List<Choice> findAll();

  Choice findById(long id);

  @Query("SELECT c FROM Choice c WHERE c.question.questionId = :questionId ")
  List<Choice> findChoiceByQuestionId(Long questionId);

  @Query("SELECT c FROM Choice c WHERE c.choiceId = :choiceId ")
  Choice findChoiceByChoiceId(Long choiceId);
}
