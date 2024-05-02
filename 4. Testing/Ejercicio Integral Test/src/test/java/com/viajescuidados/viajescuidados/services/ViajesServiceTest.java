package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ViajesServiceTest {

    @Mock
    IViajesRepository viajesRepository;

    @Mock
    PersonasService personasService;

    @Mock
    ICalculadoraDemora calculadoraDemora;

    @InjectMocks
    ViajesService viajesService;

    Persona persona;
    Persona cuidador;
    ViajeDTO viajeDTO;
    Integer personaId;
    Integer cuidadorId;
    @BeforeEach
    void setUp() {

        personaId = 1;
        cuidadorId = 2;
        persona = new Persona( personaId, "Camila", "Gomez");
        cuidador =new Persona( cuidadorId, "Erik", "Quispe");
        viajeDTO = new ViajeDTO( List.of(cuidadorId), new UbicacionDTO("Madrid", 120L, 230L),
                new UbicacionDTO("Paris", 140L, 250L));

    }

    @Test
    void duracionNuevoViajeTest() {

        when( personasService.buscarPersonaPorId(personaId)).thenReturn(persona);
        when( personasService.buscarPersonaPorId(cuidadorId)).thenReturn(cuidador);

        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);

        when( calculadoraDemora.calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino())).thenReturn(2L);

        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, personaId);

        assertEquals(2L, response.getDuracionEstimadaEnMins());

    }

    @Test
    void crearNuevoViajeTest() {

        when( personasService.buscarPersonaPorId(personaId)).thenReturn(persona);
        when( personasService.buscarPersonaPorId(cuidadorId)).thenReturn(cuidador);

        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);

        when( calculadoraDemora.calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino())).thenReturn(2L);

        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, personaId);
        nuevoViaje.setPersona(persona);
        nuevoViaje.setCuidadores( List.of( cuidador) );
        nuevoViaje.setDuracionEstimadaEnMins(2L);
        ViajeResponseDTO expected = ViajeMapper.crearViajeResponseDTO(nuevoViaje);

        assertEquals(expected, response);

    }
}