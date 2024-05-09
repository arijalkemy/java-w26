package org.example.be_java_hisp_w26_g04.util.scope;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class UtilScope {
    public static final String SCOPE;

    static {
        Properties properties = new Properties();
        String scope = "";
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            scope = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SCOPE = scope;
    }

    public static ClassPathResource getPath(String resourcePath){
        Properties properties = new Properties();
        if ("test".equals(properties.getProperty("api.scope"))) {
            resourcePath = "test/" + resourcePath;
        }
        return new ClassPathResource(resourcePath);
    }
}
