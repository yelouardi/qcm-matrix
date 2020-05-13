package com.humanup.matrix.qcm.bs.impl.listner;

import com.humanup.matrix.qcm.dao.AnswerDAO;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.entities.Answer;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.vo.AnswerVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class RabbitMQAnswerListner {
  private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQAnswerListner.class);

  @Autowired private AnswerDAO answerDAO;
  @Autowired private ChoiceDAO choiceDAO;

  @RabbitListener(queues = {"${answer.queue.name}"})
  public void receive(AnswerVO answerVO) {
    try {
      LOGGER.info("Receive  message... {} ", answerVO.toString());
      Choice choice = choiceDAO.findChoiceByChoiceId(answerVO.getChoiceId());
      String email = answerVO.getEmailPerson();

      if (null == choice || null == email || StringUtils.isEmpty(email)) {
        LOGGER.info("Received message as generic: {}", answerVO.toString());
      }

      Answer answerToSave = Answer.builder().choice(choice).emailPerson(email).build();
      answerDAO.save(answerToSave);

    } catch (Exception ex) {
      LOGGER.info("Error  message... {} ", ex.getMessage(), ex);
    }
  }
}
