package com.humanup.matrix.qcm.bs.impl.listner;

import com.humanup.matrix.qcm.dao.AnswerDAO;
import com.humanup.matrix.qcm.dao.ChoiceDAO;
import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Answer;
import com.humanup.matrix.qcm.dao.entities.Choice;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.AnswerVO;
import com.humanup.matrix.qcm.vo.ChoiceVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@RefreshScope
public class RabbitMQChoiceListner {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQChoiceListner.class);

    @Autowired
    private ChoiceDAO choiceDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @RabbitListener(queues = { "${choice.queue.name}" })
    public void receive(ChoiceVO choiceVO) {
        try {
            LOGGER.info("Receive  message... {} ", choiceVO.toString());
            Question question  = questionDAO.findQuestionByQuestionId(choiceVO.getQuestionId());

            if (null == question) {
                LOGGER.info("Received message as generic: {}", choiceVO.toString());
            }

            Choice choiceToSave  = Choice.builder()

                    .choiceText(choiceVO.getChoiceText())
                    .percentage(choiceVO.getPercentage())
                    .question(question)
                    .build();
            choiceDAO.save(choiceToSave);

        }catch(Exception ex){
            LOGGER.info("Error  message... {} ", ex.getMessage(),ex);
        }
    }

}

