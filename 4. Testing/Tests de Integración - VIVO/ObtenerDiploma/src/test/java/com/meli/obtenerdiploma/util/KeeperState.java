package com.meli.obtenerdiploma.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KeeperState {

    private static JsonNode data = null;
    private static String filePath = null;
    private static String scope = null;

    public static void copySnapShoot(String nameFile) throws FileNotFoundException {
        if (scope == null)
            scope = getScope();

        KeeperState.filePath = "./src/" + scope + "/resources/" + nameFile;
        ObjectMapper obj = new ObjectMapper();
        try {
            data = obj.readTree(ResourceUtils.getFile(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redoSnapShoot() {

        if (data == null)
            throw new RuntimeException("There is not a snapshoot");

        ObjectMapper obj = new ObjectMapper();

        try {
            File file = ResourceUtils.getFile(KeeperState.filePath);
            //file.delete();

            obj.writeValue(file ,  data);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error at redo the snapshoot");
        }
    }

    private static String getScope() {
        Properties properties =  new Properties();
        String scope = "";
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            scope = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scope;
    }
}