package com.neo.rabbit.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "direct.directQueue2")
public class DirectReceiver2 {

    @RabbitHandler
    public void process(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        try {
            channel.basicAck(deliveryTag,false);
            System.out.println("direct Receiver2 : " + message);
        } catch (IOException e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,false,true);
        }
    }

}
