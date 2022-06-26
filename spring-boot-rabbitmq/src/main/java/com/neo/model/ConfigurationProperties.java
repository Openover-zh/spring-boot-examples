package com.neo.model;

import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(value = ConfigurationProperties.class)
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "spring.rabbitmq")
@Component
@Data
public class ConfigurationProperties {
    private String host;
    private String port;
    private String username;
    private String password;

}
