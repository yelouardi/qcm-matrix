package com.humanup.matrix.qcm.bs.impl.sender;

import com.humanup.matrix.qcm.vo.AnswerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQAnswerSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQAnswerSender.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQAnswerSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${answer.queue.name}")
    String queueName;


    public void send(AnswerVO answer) {
        rabbitTemplate.convertAndSend(queueName, answer);
        LOGGER.info("Sending message... {} " ,answer.toString());
    }

}
