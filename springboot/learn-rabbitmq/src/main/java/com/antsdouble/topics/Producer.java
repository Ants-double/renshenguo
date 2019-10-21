package com.antsdouble.topics;

import com.antsdouble.simpledemo.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String message = "匹配insert";
        channel.basicPublish(EXCHANGE_NAME, "0.insert", false, false, null, message.getBytes());
        channel.close();
        connection.close();
    }
}
