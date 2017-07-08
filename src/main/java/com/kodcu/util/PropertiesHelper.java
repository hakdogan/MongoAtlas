package com.kodcu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by hakdogan on 12/06/2017.
 */
public class PropertiesHelper {

    private static InputStream inputStream;
    private static Properties prop = new Properties();
    static {
        try {
            inputStream = new FileInputStream("src/main/resources/connection.properties");
        } catch (FileNotFoundException ex){
            Logger.getLogger(PropertiesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getPropertie(String propKey){

        String result = null;

        try {

            prop.load(inputStream);
            result = prop.getProperty(propKey);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
