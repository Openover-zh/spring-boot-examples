package com.neo.rabbit.topic.Ann;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicAnnReceiver {

    @RabbitListener(bindings =
            @QueueBinding(value =
                @Queue(value = "routeQueue1"),
                    exchange = @Exchange(value = "topicExchange",type = ExchangeTypes.TOPIC,ignoreDeclarationExceptions = "true",autoDelete = "true"),key = {"router.#"}))
    public void process(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            System.out.println("Topic Receiver1  : " + message);
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,false,true);
        }
    }

    @RabbitListener(bindings =
    @QueueBinding(value =
            @Queue(value = "routeQueue2"),
            exchange = @Exchange(value = "topicExchange",type = ExchangeTypes.TOPIC,ignoreDeclarationExceptions = "true",autoDelete = "true"),key = {"router.insert","router.update"}))
    public void process2(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            System.out.println("Topic Receiver2  : " + message);
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,false,true);
        }
    }

}
