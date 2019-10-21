package com.antsdouble.simpledemo;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {

    private static final String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws IOException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel(1);
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        final StringBuffer message = new StringBuffer();
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.handleDelivery(consumerTag, envelope, properties, body);
                message.append(new String(body, "UTF-8"));
                System.out.println(new String(body, "UTF-8"));
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        System.out.println(message.toString());
    }
}
