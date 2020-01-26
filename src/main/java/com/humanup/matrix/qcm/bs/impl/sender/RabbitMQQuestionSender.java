package com.humanup.matrix.qcm.bs.impl.sender;

import com.humanup.matrix.qcm.vo.QuestionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQQuestionSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQQuestionSender.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQQuestionSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${question.queue.name}")
    String queueName;

    public void send(QuestionVO question) {
        LOGGER.info("Sending message... {} " ,question.toString());
        rabbitTemplate.convertAndSend(queueName, question);
    }

}
