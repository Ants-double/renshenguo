package com.antsdouble.rpcs;

import com.antsdouble.simpledemo.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RPCClient {
    private Connection connection;
    private Channel channel;
    private String requestQueueName="rpc_queue";
    private String replyQueueName;

    public RPCClient() throws IOException {
        connection= ConnectionUtil.getConnection();
        channel=connection.createChannel();
        replyQueueName=channel.queueDeclare().getQueue();
    }
    public String call(String message) throws IOException, InterruptedException {
        final String corrId= UUID.randomUUID().toString();
        AMQP.BasicProperties props=new AMQP.BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();
        channel.basicPublish("",requestQueueName,props,message.getBytes("UTF-8"));
        final BlockingQueue<String> response=new ArrayBlockingQueue<String>(1);
        channel.basicConsume(replyQueueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                if (properties.getCorrelationId().equals(corrId)){
                    response.offer(new String(body,"UTF-8"));
                }
            }
        });
        return response.take();

    }
    public void close() throws IOException {
        connection.close();
    }
}
