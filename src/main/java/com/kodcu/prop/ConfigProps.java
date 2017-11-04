package com.kodcu.prop;
/*
 * Created by hakdogan on 04/11/2017
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
@Getter
@Setter
public class ConfigProps {

    private String connectionurl;
    private String database;
    private String collection;
}
