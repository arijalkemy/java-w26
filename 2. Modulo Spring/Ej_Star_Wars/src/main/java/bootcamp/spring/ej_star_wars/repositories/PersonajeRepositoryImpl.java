package bootcamp.spring.ej_star_wars.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.spring.ej_star_wars.EjStarWarsApplication;
import bootcamp.spring.ej_star_wars.models.Personaje;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private List<Personaje> personajes;

    PersonajeRepositoryImpl(){
        InputStream inputStream = EjStarWarsApplication.class.getResourceAsStream("/personajes_starwars.json");
        try{
            personajes = MAPPER.readValue(inputStream, new TypeReference<List<Personaje>>() {});
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Personaje> findByName(String name) {
        return personajes
                .stream()
                .filter(personaje -> personaje.nameContains(name))
                .findFirst();
    }

}
