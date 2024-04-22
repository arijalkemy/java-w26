package StarWars.Ejercicio.Service.Impl;

import StarWars.Ejercicio.Entity.Personaje;
import StarWars.Ejercicio.Repository.StarWarsRepository;
import StarWars.Ejercicio.Service.IStarWarsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class StarWarsService implements IStarWarsService {
    private static List<Personaje> personajes;

    static {
        // Cargar datos del archivo starwars.json
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("starwars.json");
        try {
            personajes = Arrays.asList(objectMapper.readValue(resource.getFile(), Personaje[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Personaje> buscarPersonajesPorNombre(String nombre) {
        // Buscar personajes cuyo nombre contiene el término dado
        return personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }
    @Override
    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
