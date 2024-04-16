package bootcamp.spring.covid.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import bootcamp.spring.covid.models.Persona;

@Repository
public class PersonasRepository {
    
    private static List<Persona> PERSONAS = List.of(
        new Persona(1, 55, "Juan","Perez"),
        new Persona(1, 25, "Juan", "Perez"),
        new Persona(2, 30, "María", "García"),
        new Persona(3, 67, "Pedro", "López"),
        new Persona(4, 71, "Ana", "Martínez"),
        new Persona(5, 12, "Luis", "Sánchez"),
        new Persona(6, 98, "Laura", "Rodríguez"),
        new Persona(7, 17, "Carlos", "Fernández"),
        new Persona(8, 33, "Elena", "Gómez")
    );

    public List<Persona> getAll(){
        return PERSONAS;
    }
    
}
