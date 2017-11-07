package com.kodcu.controller;

import com.kodcu.dao.QueryDAO;
import com.kodcu.prop.ConfigProps;
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
    private QueryDAO dao;

    @Autowired
    private ConfigProps props;

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    @ResponseBody
    public String dropCollection(){
        return dao.dropCollection(props.getCollection());
    }
}
