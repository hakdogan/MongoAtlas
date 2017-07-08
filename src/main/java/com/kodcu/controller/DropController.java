package com.kodcu.controller;

import com.kodcu.util.QueryHelper;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hakdogan on 08/07/2017.
 */
@Controller
public class DropController {

    @Autowired
    private MongoCollection collection;

    @Autowired
    private QueryHelper queryHelper;

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    @ResponseBody
    public String dropCollection(){
        queryHelper.dropCollection(collection);
        return "The collection was dropped!";
    }
}
