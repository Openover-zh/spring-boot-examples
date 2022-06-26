package com.neo.rabbit.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
/**
 * 通过注解的方式绑定交换机和队列 没有会自动添加
 * @QueueBingding注解声明绑定交换机和队列
 *  - @Exchange绑定交换机
 *  - @Queue绑定的队列
 *  - key 为routingKey
 */
@RabbitListener(bindings =
                    @QueueBinding(
                            exchange = @Exchange(value = "directExchange",type = ExchangeTypes.DIRECT,durable = "true"),
                            value = @Queue("direct.directQueue1"),key = {"direct.message1"}))
public class DirectReceiver {

    @RabbitHandler
    public void process(String message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        try {
            System.out.println("direct Receiver1  : " + message);
            channel.basicAck(deliveryTag,false);
        } catch (IOException e) {
            e.printStackTrace();
            channel.basicNack(deliveryTag,false,true);
        }
    }

}
