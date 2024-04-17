package org.example._07starwars.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example._07starwars.Model.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RepositorioPersonajes implements IRepositorio {

    private List<Personaje> personajes;

    public RepositorioPersonajes() {
        this.personajes = cargarDatabase();
    }

    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return personajes.stream().filter(p -> p.getName().contains(nombre)).toList();
    }

    private List<Personaje> cargarDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
        };
        List<Personaje> personajes = new ArrayList<>();
        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(personajes.size());
        return personajes;

    }
}
