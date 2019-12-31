package com.humanup.matrix.qcm.dao;

import com.humanup.matrix.qcm.dao.entities.Choice;

import java.util.List;

public interface ChoiceDAO {
    Choice findByChoice(String Choice);
    List<Choice> findAll();
    Choice findById(long id);
    // @Query("SELECT q FROM Choice q WHERE lower() like %:Choice% ")
    // List<Choice> findListProfilesByProfileTitle(String Choice);
}
