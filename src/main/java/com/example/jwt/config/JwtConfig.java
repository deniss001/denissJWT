package com.example.jwt.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class JwtConfig {

    private static String apiKey;


    static {
        try {
                Configuration configuration = new Configurations().properties("jwt.properties");
            apiKey = configuration.getString("apiKey");
        } catch (ConfigurationException e) {
            System.err.println("JWT配置文件加载异常！");
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        return apiKey;
    }

}
