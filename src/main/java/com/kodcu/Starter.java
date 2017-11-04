package com.kodcu;

/**
 * Created by hakdogan on 04/11/2017
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
