import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
 * Created by hakdogan on 06/06/2017.
 */
public class MongoAtlas {

    private final static String databaseName   = "yourDatabaseName";
    private final static String collectionName = "yourCollectionName";
    private final static String connectionURL  = "yourConnectionURL";

    public static void main(String args[]){

        MongoClient mongoClient = null;

        try {

            MongoClientURI uri         = new MongoClientURI(connectionURL);
            mongoClient                = new MongoClient(uri);
            MongoDatabase db           = mongoClient.getDatabase(databaseName);
            MongoCollection collection = db.getCollection(collectionName);

            dropCollection(collection);

            System.out.println("***************** insertRecord *****************");
            insertRecord("NoSQL and MongoDB", "Hüseyin Akdoğan",
                    getSpecificDate(2017, 6,6,14,10), 1.5, collection);
            insertRecord("What's new in MongoDB", "Hüseyin Akdoğan",
                    getSpecificDate(2017, 6,6,16,0), 3, collection);
            System.out.println("***************** insertRecord *****************");

            whereQuery("speaker", "Hüseyin Akdoğan", collection);
            executeRegexQuery("subject", "NoSQL.*MongoDB", collection);
            groupQuery("speaker", "Hüseyin Akdoğan", collection);

        } catch (Exception ex) {
            Logger.getLogger(MongoAtlas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mongoClient.close();
        }

    }

    public static void insertRecord(String subject, String speaker, Date date, double time, MongoCollection collection) {

        try {

            Document document = new Document("subject", subject)
                    .append("speaker", speaker)
                    .append("date", date)
                    .append("time", time);

            collection.insertOne(document);
            System.out.println("Added entry: " + document);

        } catch (Exception ex) {
            Logger.getLogger(MongoAtlas.class.getName()).log(Level.SEVERE, null, ex);
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

    private static void groupQuery(String field, String value, MongoCollection collection){
        System.out.println("\n***************** groupQuery *****************");
        collection.aggregate(
                Arrays.asList(Aggregates.match(Filters.eq(field, value)),
                        Aggregates.group("$time", Accumulators.sum("talkTime", 1)))).
                forEach(getBlock());
        System.out.println("***************** groupQuery *****************");
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
