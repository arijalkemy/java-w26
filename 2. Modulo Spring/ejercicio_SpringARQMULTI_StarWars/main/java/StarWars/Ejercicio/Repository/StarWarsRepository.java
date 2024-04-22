package StarWars.Ejercicio.Repository;

import StarWars.Ejercicio.Entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StarWarsRepository {
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
}
