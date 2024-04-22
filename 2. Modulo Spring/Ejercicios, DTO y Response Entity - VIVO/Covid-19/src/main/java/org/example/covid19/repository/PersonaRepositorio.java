package org.example.covid19.repository;

import org.example.covid19.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepositorio {
    private static List<Persona> listaDePersonas = List.of(
            new Persona(1, "Juan", "Perez",12),
            new Persona(2, "Pedro", "Rodriguez",70),
            new Persona(3, "Mia", "Ramos",40),
            new Persona(4, "Rodrigo", "Diaz", 77)
    );

    public List<Persona>getListaDePersonas(){
        return listaDePersonas;
    }
    public List<Persona> getPersonasMayores(){
        return listaDePersonas.stream().filter(persona -> persona.getEdad() > 60).toList();
    }

}
