package com.example.demo.repository.imp;

import com.example.demo.model.Personaje;
import com.example.demo.repository.IStarWarsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StarWarsRepository implements IStarWarsRepository {

    private final List<Personaje> personajes;

    public StarWarsRepository() {
        this.personajes = cargarDatosDesdeArchivo();
    }

    private List<Personaje> cargarDatosDesdeArchivo() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data/starWars.json");
            return objectMapper.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO agregar excepcion
            return null;
        }
    }

    public List<Personaje> buscarPersonajesPorNombre(String nombre) {
        List<Personaje> resultados = new ArrayList<>();
        for (Personaje personaje : personajes) {
            if (personaje.getName().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(personaje);
            }
        }
        return resultados;
    }
}
