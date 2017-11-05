package com.kodcu.config;

import com.kodcu.prop.ConfigProps;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hakdogan on 08/07/2017.
 */
@Configuration
public class BaseConfiguration {

    @Autowired
    private ConfigProps props;

    @Bean
    public MongoCollection getCollection(){

        MongoClientURI uri = new MongoClientURI(props.getConnectionurl());
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db  = mongoClient.getDatabase(props.getDatabase());
        return db.getCollection(props.getCollection());
    }
}
