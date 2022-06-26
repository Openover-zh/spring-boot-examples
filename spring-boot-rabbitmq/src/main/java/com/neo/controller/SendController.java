package com.neo.controller;

import com.neo.rabbit.many.ack.NeoAckSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/send")
public class SendController {

    public static final String NEO_ACK_QUEUE  = "neo_ack";

    @Autowired
    private NeoAckSender neoAckSender;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/neo/ack/send")
    public void neoAckSend(){
        for (int i = 0; i <50 ; i++) {
            String message = "This is message "+i;
            rabbitTemplate.convertAndSend(NEO_ACK_QUEUE,message);
            log.info("NEO_ACK 发送消息: "+i);
        }
    }

    @GetMapping("/fanout/send")
    public void fanoutSend(){
        for (int i = 0; i < 50 ; i++) {
            String message = "This is fanout message "+i;
            // 指定交换机为fanoutExchange
            rabbitTemplate.convertAndSend("fanoutExchange","",message);
        }
    }

    @GetMapping("/direct1/send")
    public void direct1Send(){
        for (int i = 0; i < 50 ; i++) {
            String message = "This is direct1 message "+i;
            // 指定交换机为fanoutExchange
            rabbitTemplate.convertAndSend("directExchange","direct.message1",message);
        }
    }

    @GetMapping("/direct2/send")
    public void direct2Send(){
        for (int i = 0; i < 50 ; i++) {
            String message = "This is direct2 message "+i;
            // 指定交换机为fanoutExchange
            rabbitTemplate.convertAndSend("directExchange","direct.message2",message);
        }
    }

    @GetMapping("/topic/send")
    public void topic2Send(){
        for (int i = 0; i < 50 ; i++) {
            String message = "This is topic message "+i;
            // 指定交换机为fanoutExchange
//            rabbitTemplate.convertAndSend("topicExchange","router.insert",message);
            rabbitTemplate.convertAndSend("topicExchange","router.qqq",message);
        }
    }

    @GetMapping("/confirm/send")
    public void confirmSend(){
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            // product-->exchange 检测是否成功
            if (ack){
                log.info("消息成功发送");
            }else {
                log.info("消息发送失败");
                log.info("错误原因"+cause);
            }
        });
        for (int i = 0; i < 50 ; i++) {
            String message = "This is topic message "+i;
            // product-->exchange
            rabbitTemplate.convertAndSend("aaaExchange", "aaa.qqq", message);
        }
    }

    @GetMapping("/return/send")
    public void returnSend(){
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info(message.toString());
            log.info(String.valueOf(replyCode));
            log.info(replyText);
            log.info(exchange);
            log.info(routingKey);
        });
        for (int i = 0; i < 50 ; i++) {
            String message = "This is topic message "+i;
            rabbitTemplate.convertAndSend("topicExchange","aaa.qqq",message);
        }
    }




}
