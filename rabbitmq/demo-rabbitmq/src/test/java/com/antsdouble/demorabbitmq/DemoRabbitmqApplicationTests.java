package com.antsdouble.demorabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoRabbitmqApplication.class)
class DemoRabbitmqApplicationTests {

    private final static String EXCHANGE_NAME = "hello_fanout_1";
    private final static String QUEUE_NAME = "hello_queue_1";

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSend(){
        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME, false, false);
        Queue queue = new Queue(QUEUE_NAME, false);
        rabbitAdmin.declareExchange(fanoutExchange);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(fanoutExchange));

        Message message = new Message("hello world.".getBytes(), new MessageProperties());
        rabbitTemplate.send(EXCHANGE_NAME, "", message);
    }



}
