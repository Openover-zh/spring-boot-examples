package com.neo.rabbit.hello;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Component
@RabbitListener(queues = "hello") //指定监听队列名
@Slf4j
public class HelloReceiver {

    @RabbitHandler // 指定默认接受方法
    public void process(String hello, Channel channel, Message message) throws IOException {
        try {
            System.out.println("Receiver  : " + hello);
            System.out.println("Message : "+ message);
            System.out.println("Channel: "+channel);
            System.out.println(10/0);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            // 如果发生异常将消息回退到原队列中
            // multiple: true为批量回退  requeue:true为回退到队列中 false丢弃消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        }


    }

}
