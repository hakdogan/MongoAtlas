package com.kodcu.provider;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import con.kodcu.util.PropertiesHelper;
import org.bson.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hakdogan on 12/06/2017.
 */
public class ConnectionProvider {

    private static ConnectionProvider instance = null;
    private static Object lock = new Object();

    private static MongoClient mongoClient;

    public static ConnectionProvider instance() {

        if(Objects.isNull(instance)) {
            synchronized (lock) {
                if(Objects.isNull(instance))
                    instance = new ConnectionProvider();
            }
        }
        return instance;
    }

    public MongoClient getClient(){

        if(Objects.isNull(mongoClient)){
            MongoClientURI uri = new MongoClientURI(PropertiesHelper.getPropertie("connectionurl"));
            mongoClient        = new MongoClient(uri);
        }

        return mongoClient;
    }
}
