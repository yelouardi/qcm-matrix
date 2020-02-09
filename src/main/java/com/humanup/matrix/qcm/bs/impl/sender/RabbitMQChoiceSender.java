package com.humanup.matrix.qcm.bs.impl.sender;

import com.humanup.matrix.qcm.vo.ChoiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQChoiceSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQChoiceSender.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQChoiceSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${choice.queue.name}")
    String queueName;

    public void send(ChoiceVO choice) {
        LOGGER.info("Sending message... {} " ,choice.toString());
        rabbitTemplate.convertAndSend(queueName, choice);
    }

}
