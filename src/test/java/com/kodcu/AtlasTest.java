package com.kodcu;
/*
 * Created by hakdogan on 04/11/2017
 */

import com.kodcu.util.Constants;
import com.kodcu.util.QueryHelper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class AtlasTest {

    @Autowired
    private MongoCollection mongoCollection;

    @Autowired
    private QueryHelper queryHelper;

    @Test
    public void findDocuments() {
        FindIterable<Document> docs = queryHelper.whereQuery(Constants.INDEXES_FIELD, "", mongoCollection);
        assertNotNull(docs);
    }
}
