//package com.neo.rabbit;
//
//import org.springframework.amqp.core.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class DirectRabbitConfig {
//
//    final static String message = "direct.directQueue1";
//    final static String messages = "direct.directQueue2";
//
//    @Bean
//    public Queue directQueue1() {
//        return new Queue(DirectRabbitConfig.message);
//    }
//
//    @Bean
//    public Queue directQueue2() {
//        return new Queue(DirectRabbitConfig.messages);
//    }
//
//    @Bean("directExchange")
//    DirectExchange exchange() {
//        return new DirectExchange("directExchange");
//    }
//
//    /**
//     * 绑定topicExchange交换机和queueMessage队列
//     * 并且指定routingKey为topic.message
//     * @param directQueue1
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeDirect1(@Qualifier("directQueue1") Queue directQueue1, DirectExchange exchange) {
//        return BindingBuilder.bind(directQueue1).to(exchange).with("direct.message1");
//    }
//
//    /**
//     * 绑定topicExchange交换机和queueMessages队列
//     * 并指定柔婷Key通配符为topic.#
//     *  - #代表多个占位符  *只代表一个占位符
//     * @param directQueue2
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeDirect2(@Qualifier("directQueue2") Queue directQueue2, DirectExchange exchange) {
//        return BindingBuilder.bind(directQueue2).to(exchange).with("direct.message2");
//    }
//}
