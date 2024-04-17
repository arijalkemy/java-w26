package com.starwars.starwars.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.model.CharacterModel;

public class JsonManage {
    public static String loadJsonFile(String fileName) throws IOException {
        // Load the JSON file from the src folder
        ClassPathResource resource = new ClassPathResource(fileName);
        InputStream inputStream = resource.getInputStream();

        try {
            byte[] jsonBytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(jsonBytes, StandardCharsets.UTF_8);
        } finally {
            inputStream.close();
        }
    }

    public static List<CharacterModel> deserializeJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<List<CharacterModel>>() {});
    }
}
