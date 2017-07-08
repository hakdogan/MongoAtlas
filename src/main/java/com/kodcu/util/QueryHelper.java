package com.kodcu.util;

import com.kodcu.provider.ConnectionProvider;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hakdogan on 12/06/2017.
 */
@Component
public class QueryHelper {

//    public static void insertRecord(String subject, String speaker, Date date, double time, MongoCollection collection) {
//
//        try {
//
//            Document document = new Document("subject", subject)
//                    .append("speaker", speaker)
//                    .append("date", date)
//                    .append("time", time);
//
//            collection.insertOne(document);
//            Logger.getLogger(QueryHelper.class.getName()).info("Added entry: " + document);
//
//        } catch (Exception ex) {
//            Logger.getLogger(QueryHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }


    public FindIterable whereQuery(String field, String value, MongoCollection collection){
        return collection.find(new Document(field, value));
    }


    public void executeRegexQuery(String field, String value, MongoCollection collection){
        collection.find(new Document(field, new Document("$regex", value).append("$options", "i"))).forEach(getBlock());
    }

    public void groupQuery(String field, String value, MongoCollection collection){
        collection.aggregate(
                Arrays.asList(Aggregates.match(Filters.eq(field, value)),
                        Aggregates.group("$time", Accumulators.sum("talkTime", 1)))).
                forEach(getBlock());
    }

    public void getAllDocuments(MongoCollection collection){
        collection.find().forEach(getBlock());
    }

    public void dropCollection(MongoCollection collection){
        collection.drop();
        Logger.getLogger(QueryHelper.class.getName()).log(Level.INFO, "The collection was dropped!");
    }

    public Date getSpecificDate(int year, int month, int dayOfMonth, int hour, int minute){
        LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public Block<Document> getBlock(){
        return new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
    }
}
