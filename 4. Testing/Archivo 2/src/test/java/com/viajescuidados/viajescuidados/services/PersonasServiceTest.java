package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.services.PersonasService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonasServiceTest {
    @Mock
    private IPersonasRepository personasRepository;

    @InjectMocks
    private PersonasService personasService;

    @Test
    @DisplayName("Se crea a Juan como persona")
    public void crearPersonaTest() {
        PersonaDTO personaACrear = new PersonaDTO("Juan", "Perez");

        PersonaResponseDTO respuesta = personasService.crearPersona(personaACrear);

        verify(personasRepository, atLeast(1)).guardar(any());

        Assertions.assertEquals("Juan", respuesta.getNombre());
        Assertions.assertEquals("Perez", respuesta.getApellido());
    }
    @Test
    @DisplayName("buscar persona por ID existente")
    void buscarPersonaTest() {
        // Mock de una persona existente

    }

    @Test
    @DisplayName("buscar persona por ID existente")
    void buscarPersonaPorIdExistenteTest() {
        // Mock de una persona existe
    }

}
