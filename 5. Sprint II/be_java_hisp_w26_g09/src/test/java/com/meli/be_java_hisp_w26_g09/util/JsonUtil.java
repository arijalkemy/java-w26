package com.meli.be_java_hisp_w26_g09.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonFromFile(String fileName, Class<T> valueType) throws IOException {
        String filePath = "src/test/resources/json/" + fileName;
        File file = new File(filePath);
        return objectMapper.readValue(file, valueType);
    }

    public static <T> List<T> readJsonFromFileToList(String fileName, Class<T> valueType) throws IOException {
        String filePath = "src/test/resources/json/" + fileName;
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, valueType));
    }

}
