package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.PersonaDTO;
import com.viajescuidados.dtos.responses.PersonaResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.utils.ubicaciones.CalculadoraDemora;
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
    @DisplayName("Se crea a Juan como persona.")
    public void crearPersonaTest() {
        PersonaDTO personaACrear = new PersonaDTO("Juan", "Perez");

        PersonaResponseDTO respuesta = personasService.crearPersona(personaACrear);

        verify(personasRepository, atLeast(1)).guardar(any());

        Assertions.assertEquals("Juan", respuesta.getNombre());
        Assertions.assertEquals("Perez", respuesta.getApellido());
    }

    @Test
    @DisplayName("Verificar el comportamiento del método calcular demora entre viajes.")
    public void calcularDemoraEntreViajesTest() {
        // Arrange
        long timeExpected = 2L;
        CalculadoraDemora calculadoraDemora = new CalculadoraDemora();
        // Creacion de ubicaciones de prueba
        Ubicacion origen = new Ubicacion("Origen", 1L, 1L);
        Ubicacion destino = new Ubicacion("Destino", 2L, 2L);
        // Act
        Long demora = calculadoraDemora.calcularDemoraEntre(origen, destino);
        // Assert
        Assertions.assertEquals(timeExpected, demora);
    }

    @Test
    @DisplayName("Verificar el comportamiento del método buscar persona por id")
    public void buscarUsuarioIdTest(){
        // Arrange
        Persona persona = new Persona(1, "Juan", "Lopez");
        when(personasRepository.buscarPorId(1)).thenReturn(Optional.of(persona));
        // Act
        Persona personaBuscada = personasService.buscarPersonaPorId(1);
        // Assert
        Assertions.assertEquals(persona, personaBuscada);
    }

    @Test
    @DisplayName("Verificar el comportamiento del método buscar persona por id cuando no se encuentra")
    public void buscarUsuarioIdNotFoundTest(){
        // Arrange
        when(personasRepository.buscarPorId(1)).thenReturn(Optional.empty());
        // Act
        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> personasService.buscarPersonaPorId(1));
    }

    @Test
    @DisplayName("Verificar el comportamiento del método buscar persona que regresa un DTO")
    public void buscarPersonaTest(){
        // Arrange
        Persona persona = new Persona(1, "Juan", "Lopez");
        when(personasRepository.buscarPorId(1)).thenReturn(Optional.of(persona));
        // Act
        PersonaResponseDTO personaBuscada = personasService.buscarPersona(1);
        // Assert
        Assertions.assertEquals(persona.getNombre(), personaBuscada.getNombre());
        Assertions.assertEquals(persona.getApellido(), personaBuscada.getApellido());
    }

}
