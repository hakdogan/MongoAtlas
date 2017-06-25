package con.kodcu.util;

import com.kodcu.provider.ConnectionProvider;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

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
public class QueryHelper {

    public static void insertRecord(String subject, String speaker, Date date, double time, MongoCollection collection) {

        try {

            Document document = new Document("subject", subject)
                    .append("speaker", speaker)
                    .append("date", date)
                    .append("time", time);

            collection.insertOne(document);
            System.out.println("Added entry: " + document);

        } catch (Exception ex) {
            Logger.getLogger(ConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void whereQuery(String field, String value, MongoCollection collection){
        System.out.println("\n****************** whereQuery ******************");
        collection.find(new Document(field, value)).forEach(getBlock());
        System.out.println("****************** whereQuery ******************");
    }

    public static void executeRegexQuery(String field, String value, MongoCollection collection){
        System.out.println("\n***************** executeRegexQuery *****************");
        collection.find(new Document(field, new Document("$regex", value).append("$options", "i"))).forEach(getBlock());
        System.out.println("***************** executeRegexQuery *****************");
    }

    public static void groupQuery(String field, String value, MongoCollection collection){
        System.out.println("\n***************** groupQuery *****************");
        collection.aggregate(
                Arrays.asList(Aggregates.match(Filters.eq(field, value)),
                        Aggregates.group("$time", Accumulators.sum("talkTime", 1)))).
                forEach(getBlock());
        System.out.println("***************** groupQuery *****************");
    }

    public static void getAllDocuments(MongoCollection collection){
        System.out.println("\n****************** list all documents ******************");
        collection.find().forEach(getBlock());
        System.out.println("****************** list all documents ******************");
    }

    public static void dropCollection(MongoCollection collection){
        collection.drop();
        System.out.println("Collection is reset\n");
    }

    public static Date getSpecificDate(int year, int month, int dayOfMonth, int hour, int minute){
        LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Block<Document> getBlock(){
        return new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
    }
}
