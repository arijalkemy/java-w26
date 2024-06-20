package org.example.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadoracalorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class PlatoRepository {

    private List<Plato> platos;

    public PlatoRepository() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Plato>> typeReference = new TypeReference<List<Plato>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/food.json");
        platos = mapper.readValue(inputStream, typeReference);
    }

    public List<Plato> getAllPlatos() {
        return platos;
    }
}
