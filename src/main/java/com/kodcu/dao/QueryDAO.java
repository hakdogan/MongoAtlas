package com.kodcu.dao;
/*
 * Created by hakdogan on 07/11/2017
 */

import com.kodcu.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class QueryDAO {

    @Autowired
    private MongoOperations mongos;

    public String getMatchCountByPrefix(String prefix){
        final Query query = new Query().addCriteria(
                Criteria.where("comment").regex("^" + prefix));
        return String.valueOf(mongos.count(query, Comments.class));
    }

    public String dropCollection(String collectionName){
        mongos.dropCollection(collectionName);
        return "The collection was dropped!";
    }
}
