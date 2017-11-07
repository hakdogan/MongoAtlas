package com.kodcu.controller;

import com.kodcu.dao.QueryDAO;
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
    private QueryDAO dao;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public String executeQuery(@RequestBody String postPayload){
        return dao.getMatchCountByPrefix(postPayload);
    }
}
