package com.kodcu.config;

import com.kodcu.prop.ConfigProps;
import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by hakdogan on 08/07/2017.
 */
@Configuration
@Slf4j
public class BaseConfiguration {

    @Autowired
    private ConfigProps props;

    @Bean
    public MongoClient getMongoClient() {
        MongoClient client = null;
        try {
            MongoClientURI uri = new MongoClientURI(props.getConnectionurl());
            client = new MongoClient(uri);
        } catch (Exception ex) {
            log.info("Exception: " + ex);
        }
        return client;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(getMongoClient(), props.getDatabase());
    }
}
