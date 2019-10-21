package com.antsdouble.routing;

import com.antsdouble.simpledemo.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static  final String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");
        String message="这是消息B";
        channel.basicPublish(EXCHANGE_NAME,"B",null,message.getBytes());
        String messageA="这是消息A";
        channel.basicPublish(EXCHANGE_NAME,"A",null,messageA.getBytes());
        System.out.println("生产者消息:"+message);
        System.out.println("生产者消息:"+messageA);

        channel.close();
        connection.close();
    }
}
