package com.antsdouble.simpledemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static  final String QUEUE_NAME="test_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection=ConnectionUtil.getConnection();
        System.out.println(connection);

        Channel channel=connection.createChannel(1);
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message="Hello World";
        for (int i=0;i<20;i++){
            message=message+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("生产者 send :"+message);
            Thread.sleep(1000);
        }
        channel.close();
        connection.close();
    }
}
