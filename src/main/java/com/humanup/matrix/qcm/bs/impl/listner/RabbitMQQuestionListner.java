package com.humanup.matrix.qcm.bs.impl.listner;

import com.humanup.matrix.qcm.dao.QuestionDAO;
import com.humanup.matrix.qcm.dao.entities.Question;
import com.humanup.matrix.qcm.vo.QuestionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQQuestionListner {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQQuestionListner.class);


    @Autowired
    private QuestionDAO questionDAO;

    @RabbitListener(queues = { "${question.queue.name}" })
    public void receive(QuestionVO questionVO) {
        try{
        LOGGER.info("Receive  message... {} " ,questionVO.toString());

        Question questionToSave =  Question.builder()
                .questionText(questionVO.getQuestionText())
                .questionId(questionVO.getQuestionId())
                .build();
            questionDAO.save(questionToSave);
        }catch(Exception ex){
            LOGGER.info("Error  message... {} ", ex.getMessage(),ex);

        }
    }

}

