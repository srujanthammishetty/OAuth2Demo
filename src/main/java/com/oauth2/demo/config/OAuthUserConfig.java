package com.oauth2.demo.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Created by srujant on 14/3/18.
 */
public class OAuthUserConfig {
    public static String FB_CLIENT_SECRET;
    public static String FB_CLIENT_ID;
    public static String GOOGLE_CLIENT_ID_VALUE;
    public static String GOOGLE_CLIENT_SECRET_VALUE;

    private static Properties properties = null;

    static {
        try {
            FileReader fileReader = new FileReader(new File(OAuthUserConfig.class.getResource("/config.properties").toURI().getPath()));
            properties = new Properties();
            properties.load(fileReader);

            GOOGLE_CLIENT_ID_VALUE = properties.getProperty("GoogleClientId");
            GOOGLE_CLIENT_SECRET_VALUE = properties.getProperty("GoogleClientSecret");
            FB_CLIENT_ID = properties.getProperty("facebook_Client_ID ");
            FB_CLIENT_SECRET = properties.getProperty("facebook_Client_Secret");

        } catch (IOException e) {
            throw new RuntimeException("Failed to read config properties");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}

