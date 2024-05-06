package com.viajescuidados.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.PersonasRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
