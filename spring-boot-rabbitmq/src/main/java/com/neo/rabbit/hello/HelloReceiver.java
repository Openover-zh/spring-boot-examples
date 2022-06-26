package com.neo.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "hello") //指定监听队列名
public class HelloReceiver {

    @RabbitHandler // 指定默认接受方法
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);

    }

}
