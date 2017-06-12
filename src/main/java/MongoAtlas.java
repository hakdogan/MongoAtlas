import com.kodcu.provider.ConnectionProvider;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import con.kodcu.util.PropertiesHelper;
import con.kodcu.util.QueryHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hakdogan on 06/06/2017.
 */
public class MongoAtlas {

    public static void main(String args[]){

        MongoClient client         = ConnectionProvider.instance().getClient();
        MongoDatabase db           = client.getDatabase(PropertiesHelper.getPropertie("database"));
        MongoCollection collection = db.getCollection(PropertiesHelper.getPropertie("collection"));

        try {

            QueryHelper.dropCollection(collection);

            System.out.println("***************** insertRecord *****************");
            QueryHelper.insertRecord("NoSQL and MongoDB", "Hüseyin Akdoğan",
                    QueryHelper.getSpecificDate(2017, 6,6,14,10), 1.5, collection);

            QueryHelper.insertRecord("What's new in MongoDB?", "Hüseyin Akdoğan",
                    QueryHelper.getSpecificDate(2017, 6,6,16,0), 3, collection);
            System.out.println("***************** insertRecord *****************");

            QueryHelper.whereQuery("speaker", "Hüseyin Akdoğan", collection);
            QueryHelper.executeRegexQuery("subject", "NoSQL.*MongoDB", collection);
            QueryHelper.groupQuery("speaker", "Hüseyin Akdoğan", collection);

        } catch (Exception ex) {
            Logger.getLogger(MongoAtlas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            client.close();
        }

    }
}
