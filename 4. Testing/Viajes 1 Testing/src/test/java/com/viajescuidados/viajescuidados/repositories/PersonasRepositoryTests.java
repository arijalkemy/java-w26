package com.viajescuidados.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.PersonasRepository;
import com.viajescuidados.repositories.PersonasRepositoryTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonasRepositoryTests {
    private PersonasRepository personasRepository;
    private PersonasRepositoryTest personasRepositoryTest;


    @BeforeEach
    public void setup() {
        this.personasRepository = new PersonasRepository();
        this.personasRepositoryTest = new PersonasRepositoryTest();
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
    @DisplayName("Buscamos a Juan por id y lo encontramos")
    public void buscarPersonaPorIdTest() {
        Persona juan = new Persona();
        juan.setNombre("Juan");
        juan.setApellido("Perez");

        personasRepository.guardar(juan);

        Persona personaEncontrada = personasRepository.buscarPorId(1).orElse(null);

        Assertions.assertNotNull(personaEncontrada);
        Assertions.assertEquals("Juan", personaEncontrada.getNombre());
        Assertions.assertEquals("Perez", personaEncontrada.getApellido());
    }

    @Test
    @DisplayName("Buscamos a Juan por id y no lo encontramos")
    public void buscarPersonaPorIdNoEncontradaTest() {
        Persona personaEncontrada = personasRepository.buscarPorId(1).orElse(null);

        Assertions.assertNull(personaEncontrada);
    }

    @Test
    @DisplayName("Obtenemos la lista de todos los usuarios")
    public void obtenerTodosLosUsuariosTest() {
        Persona juan = new Persona();
        juan.setNombre("Juan");
        juan.setApellido("Perez");

        personasRepository.guardar(juan);

        Persona maria = new Persona();
        maria.setNombre("Maria");
        maria.setApellido("Gomez");

        personasRepository.guardar(maria);

        Assertions.assertEquals(2, personasRepository.buscarTodos().size());
    }

    @Test
    @DisplayName("Obtenemos la lista de todos los usuarios de repositorio de prueba")
    public void obtenerTodosLosUsuariosDeRepositorioTest() {
        Assertions.assertEquals(3, personasRepositoryTest.buscarTodos().size());
    }


}
