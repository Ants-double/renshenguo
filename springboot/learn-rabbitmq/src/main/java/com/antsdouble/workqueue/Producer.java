package com.antsdouble.workqueue;

import com.antsdouble.simpledemo.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        for (int i = 0; i < 5000; i++) {
            String message = "" + i;
            System.out.println(message);
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            Thread.sleep(100 * i);
        }
        channel.close();
        connection.close();
    }
}
