package com.kodcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hakdogan on 02/07/2017.
 */
@Controller
public class WelcomePageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPage(){
        return "index";
    }
}
