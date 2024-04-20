package com.sinc_ejerciciostarwars.repositorio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sinc_ejerciciostarwars.SincEjercicioStarWarsApplication;
import com.sinc_ejerciciostarwars.entidad.Personaje;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@Repository
public class Repositorio {

    public static List<Personaje> personajes;

    static {
        try (Reader reader = new FileReader("src/main/java/com/sinc_ejerciciostarwars/repositorio/starwars.json")) {
            Gson gson = new Gson();

            // Convertir el JSON en una lista de objetos Personaje
            Personaje[] personajesArray = gson.fromJson(reader, Personaje[].class);
            personajes = Arrays.asList(personajesArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
