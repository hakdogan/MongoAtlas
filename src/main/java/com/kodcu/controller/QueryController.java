package com.kodcu.controller;

import com.kodcu.util.Constants;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Indexes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hakdogan on 02/07/2017.
 */
@Controller
public class QueryController {

    @Autowired
    private MongoCollection mongoCollection;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String executeQuery(@RequestBody String postPayload){
        mongoCollection.createIndex(Indexes.text(Constants.INDEXES_FIELD));
        return String.valueOf(mongoCollection.count(Filters.text(postPayload)));
    }
}
