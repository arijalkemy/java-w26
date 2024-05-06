package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonasService;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    Viaje nuevoViaje;
    @BeforeEach
    void setUp() {

        personaId = 1;
        cuidadorId = 2;
        persona = new Persona( personaId, "Camila", "Gomez");
        cuidador =new Persona( cuidadorId, "Erik", "Quispe");
        viajeDTO = new ViajeDTO( List.of(cuidadorId), new UbicacionDTO("Madrid", 120L, 230L),
                new UbicacionDTO("Paris", 140L, 250L));
        nuevoViaje = ViajeMapper.crearViaje(viajeDTO);
    }
    //Crear Viaje
    @Test
    void duracionNuevoViajeTest() {

        when( personasService.buscarPersonaPorId(anyInt())).thenReturn(persona);
        when( personasService.buscarPersonaPorId(cuidadorId)).thenReturn(cuidador);



        when( calculadoraDemora.calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino())).thenReturn(2L);

        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, personaId);

        Assertions.assertEquals(2L, response.getDuracionEstimadaEnMins());

    }

    @Test
    //TODO: no esta andando del todo
    void crearNuevoViajeTest() {

        when( personasService.buscarPersonaPorId(personaId)).thenReturn(persona);
        when( personasService.buscarPersonaPorId(cuidadorId)).thenReturn(cuidador);

        Viaje nuevoViaje = ViajeMapper.crearViaje(viajeDTO);
        ViajeResponseDTO expected = ViajeMapper.crearViajeResponseDTO(nuevoViaje);

        when( calculadoraDemora.calcularDemoraEntre(nuevoViaje.getOrigen(), nuevoViaje.getDestino())).thenReturn(2L);

        ViajeResponseDTO response = viajesService.crearViaje(viajeDTO, personaId);

        Assertions.assertEquals(expected, response);

    }
    @Test
    void comenzarViajeBadTest(){
        when(viajesRepository.buscarPorId(1)).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class, () -> viajesService.comenzarViaje(1));
    }

    //Comenzar Viaje

    @Test
    void comenzarViajeTest(){

        nuevoViaje.setPersona(persona);
        nuevoViaje.setEstado(EstadoViaje.NO_INICIADO);
        nuevoViaje.setFechaComienzo(LocalDateTime.now());

        when(viajesRepository.buscarPorId(1)).thenReturn(Optional.of(nuevoViaje));

        ViajeResponseDTO response = viajesService.comenzarViaje(1);

        Assertions.assertEquals(EstadoViaje.EN_PROCESO.toString(), response.getEstado().toString());
    }


}