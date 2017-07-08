package com.kodcu.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.kodcu.util.PropertiesHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hakdogan on 08/07/2017.
 */
@Configuration
public class BaseConfiguration {

    @Bean
    public MongoCollection getCollection(){

        MongoClientURI uri = new MongoClientURI(PropertiesHelper.getPropertie("connectionurl"));
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db  = mongoClient.getDatabase(PropertiesHelper.getPropertie("database"));

        return db.getCollection(PropertiesHelper.getPropertie("collection"));
    }
}
