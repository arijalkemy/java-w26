package com.meli.obtenerdiploma.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSourcer {

    private static File fileSnapShoot = null;
    private static Object data = null;

    public static void copySnapShoot(String filePath) throws FileNotFoundException {
        fileSnapShoot = ResourceUtils.getFile(filePath);
        ObjectMapper obj = new ObjectMapper();
        try {
            data = obj.readValue(fileSnapShoot, Object.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redoSnapShoot() {

        if (fileSnapShoot == null || data == null)
            throw new RuntimeException("There is not a snapshoot");

        ObjectMapper obj = new ObjectMapper();

        try {
            obj.writeValue(fileSnapShoot, data);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error at redo the snapshoot");
        }
    }
}
