package com.example.starwars.repositorio;

import com.example.starwars.modelo.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RepositorioPersonaje {
    //Atributos
    private List<Personaje> lista_personaje = new ArrayList<>();

    public RepositorioPersonaje(){
        this.ejemplificarRepositorio();
    }

    public void ejemplificarRepositorio(){
        try {
            // Lee el archivo JSON desde la carpeta resources
            ClassPathResource objtResource = new ClassPathResource("datos.json");
            ObjectMapper objtMapper = new ObjectMapper();

            // Mapea el archivo JSON a una lista de Personajes
            Personaje[] personasArray = objtMapper.readValue(objtResource.getInputStream(), Personaje[].class);
            lista_personaje = Arrays.asList(personasArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Personaje> filtrarRepositorioPersonaje(String filtro){
        // Filtrar la lista de personas para obtener solo aquellas cuya edad sea mayor que 25
        List<Personaje> personajesFiltrados= lista_personaje.stream()
                .filter(personaje -> personaje.getNombre().contains(filtro))
                .toList();
        return personajesFiltrados;
    }

    public List<Personaje> getLista_personaje() {
        return lista_personaje;
    }
}
