package com.neo.rabbit.fanout;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            System.out.println("fanout Receiver A: " + message);
//            int i = 1/0;
            channel.basicAck(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,false,true);
        }
    }

}
