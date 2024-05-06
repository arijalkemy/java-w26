package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.services.PersonasService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
    @DisplayName("Se devuelve Juan al buscar por id")
    public void buscarPersonaTest() {
        Persona personaMock = Persona.builder()
                .nombre("Juan")
                .apellido("Perez")
                .build();
        when(personasRepository.buscarPorId(1)).thenReturn(Optional.of(personaMock));
        PersonaResponseDTO respuesta = personasService.buscarPersona(1);
        verify(personasRepository, atLeast(1)).buscarPorId(any());

        Assertions.assertEquals("Juan", respuesta.getNombre());
    }
    @Test
    @DisplayName("Buscar persona no existente arroja excepcion")
    public void buscarPersonaNoExistenteTest() {
        when(personasRepository.buscarPorId(1092)).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> personasService.buscarPersona(1092));
    }
}
