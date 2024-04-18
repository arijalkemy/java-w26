package org.example.integradorstarwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integradorstarwars.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class CharacterRepository {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public CharacterRepository(ResourceLoader resourceLoader, ObjectMapper objectMapper){
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;

    }

    public List<Character> loadData() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:star.json");
        InputStream inputStream = resource.getInputStream();

        try {
            return objectMapper.readValue(inputStream, new TypeReference<List<Character>>() {
            });
        } finally {
            inputStream.close();
        }
    }

}
