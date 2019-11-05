package com.antsdouble;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/11/5
 */
public class MsgReceiver {
    private final static String EXCHANGE_NAME = "hello_fanout_1";
    private final static String QUEUE_NAME = "hello_queue_1";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)  throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("receive message:"+message);
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
