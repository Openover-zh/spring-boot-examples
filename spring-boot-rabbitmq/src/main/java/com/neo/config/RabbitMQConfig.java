//package com.neo.config;
//
//import com.neo.model.ConfigurationProperties;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.SimpleMessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.retry.backoff.ExponentialBackOffPolicy;
//import org.springframework.retry.support.RetryTemplate;
//
//@Configuration
//public class RabbitMQConfig {
//
//
//    @Autowired
//    private RabbitProperties props;
//    @Bean
//    public CachingConnectionFactory defaultConnectionFactory(){
//        CachingConnectionFactory cf = new CachingConnectionFactory();
//        cf.setHost(this.props.getHost());
//        cf.setUsername(this.props.getUsername());
//        cf.setPassword(this.props.getPassword());
//        return cf;
//    }
//    @Bean
//    public RabbitTemplate rabbitTemplate(){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(defaultConnectionFactory());
//        // 这里可以设置消息转换器 设置默认编码等 https://docs.spring.io/spring-amqp/docs/current/reference/html/#message-converters
//        SimpleMessageConverter simpleMessageConverter = new SimpleMessageConverter();
//        simpleMessageConverter.setDefaultCharset("utf-8");
//        rabbitTemplate.setMessageConverter(simpleMessageConverter);
////         消息重试
//        RetryTemplate retryTemplate = new RetryTemplate();
//        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
//        backOffPolicy.setInitialInterval(500);
//        backOffPolicy.setMultiplier(10.0);
//        backOffPolicy.setMaxInterval(10000);
//        retryTemplate.setBackOffPolicy(backOffPolicy);
//        rabbitTemplate.setRetryTemplate(retryTemplate);
//        return rabbitTemplate;
//    }
//
//}
