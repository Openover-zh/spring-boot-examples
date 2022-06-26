//package com.neo.rabbit;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class TopicRabbitConfig {
//
//    final static String message = "topic.message";
//    final static String messages = "topic.messages";
//
//    @Bean
//    public Queue queueMessage() {
//        return new Queue(TopicRabbitConfig.message);
//    }
//
//    @Bean
//    public Queue queueMessages() {
//        return new Queue(TopicRabbitConfig.messages);
//    }
//
//    @Bean("topicExchange")
//    TopicExchange exchange() {
//        return new TopicExchange("topicExchange");
//    }
//
//    /**
//     * 绑定topicExchange交换机和queueMessage队列
//     * 并且指定routingKey为topic.message
//     * @param queueMessage
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
//    }
//
//    /**
//     * 绑定topicExchange交换机和queueMessages队列
//     * 并指定柔婷Key通配符为topic.#
//     *  - #代表多个占位符  *只代表一个占位符
//     * @param queueMessages
//     * @param exchange
//     * @return
//     */
//    @Bean
//    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
//        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
//    }
//}
