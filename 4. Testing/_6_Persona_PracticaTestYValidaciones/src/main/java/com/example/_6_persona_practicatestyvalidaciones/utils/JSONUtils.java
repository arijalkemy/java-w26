package com.example._6_persona_practicatestyvalidaciones.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> loadListFromFile(String fileName, Class<T> type) {
        try {
            File file = new ClassPathResource(fileName).getFile();
            return objectMapper.readValue(file, objectMapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, type));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void saveListToFile(String fileName, List<T> list) {
        try {
            File file = new File(new ClassPathResource(fileName).getURI());
            objectMapper.writeValue(new FileOutputStream(file), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
