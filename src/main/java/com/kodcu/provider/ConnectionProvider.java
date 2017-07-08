package com.kodcu.provider;

import com.mongodb.*;
import com.kodcu.util.PropertiesHelper;

import java.util.Objects;

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
