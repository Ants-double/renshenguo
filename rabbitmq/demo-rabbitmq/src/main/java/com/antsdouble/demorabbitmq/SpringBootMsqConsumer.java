package com.antsdouble.demorabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/11/5
 */
@Component
public class SpringBootMsqConsumer {
    @RabbitListener(queues = "hello_queue_1")
    public void receive(Message message) {
        System.out.println("receive message:" + new String(message.getBody()));
    }
}

