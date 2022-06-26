package com.neo.rabbit.many.ack;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RabbitListener(queues = "neo_ack")
@Slf4j
public class NeoAckReceiver1 {

    List<String> list = new ArrayList<String>();

    @RabbitHandler
    public void process(String neo, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        try {
           log.info("NEO_ACK Receiver 1: " + neo);
            TimeUnit.SECONDS.sleep(1);
            // 手动确认签收消息 basicAck(消息唯一标识,是否批量签收)
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            e.printStackTrace();
            // basicReject 和  basicNack 都是拒绝消息 但是basicReject不能批量拒绝
//            channel.basicReject(deliveryTag,true);
            //拒绝消息 basicNack(消息唯一标识,是否批量签收,是否重新返回队列)
            channel.basicNack(deliveryTag,false,true);
        }
    }

}
