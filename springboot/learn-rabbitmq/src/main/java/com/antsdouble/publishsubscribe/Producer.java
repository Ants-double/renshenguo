package com.antsdouble.publishsubscribe;

import com.antsdouble.simpledemo.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection= ConnectionUtil.getConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout",true,true,null);
        String message="订阅消息";
        channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
        System.out.println("生产者 send:"+message);
        channel.close();
        connection.close();

    }
}
