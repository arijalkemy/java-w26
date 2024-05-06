package com.viajescuidados.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.PersonasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonasRepositoryTest {
    private PersonasRepository personasRepository;

    @BeforeEach
    public void setup() {
        this.personasRepository = new PersonasRepository();
    }

    @Test
    @DisplayName("Guardamos a Juan y se le asigna un id")
    public void guardamosAPersonaCorrectamente() {
        Persona juan = new Persona();
        juan.setNombre("Juan");
        juan.setApellido("Perez");

        personasRepository.guardar(juan);

        Assertions.assertEquals(1, juan.getId());
    }

    @Test
    @DisplayName("Verificar personas existentes en la bd")
    public void checkAllPersonList() {
       Persona persona = new Persona();
        persona.setId(1);
        persona.setNombre("Juan");
        persona.setApellido("Perez");

        // Guarda en el repo
        personasRepository.guardar(persona);

        List<Persona> listaPersonas = personasRepository.buscarTodos();

        // Assert
        Assertions.assertTrue(listaPersonas.contains(persona));
    }
}
