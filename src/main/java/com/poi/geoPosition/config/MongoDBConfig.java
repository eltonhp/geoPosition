package com.poi.geoPosition.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Elton H. Paula
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.data.mongodb")
@Data
public class MongoDBConfig {
    @Getter @Setter
    private String uri;
    @Getter @Setter
    private String database;


}
