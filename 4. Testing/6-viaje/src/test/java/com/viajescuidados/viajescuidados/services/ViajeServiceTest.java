package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.mappers.ViajeMapper;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.repositories.ViajesRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonasService;
import com.viajescuidados.services.interfaces.IViajesService;
import com.viajescuidados.services.utils.ubicaciones.CalculadoraDemora;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ViajeServiceTest {

    @Mock
    ViajesRepository viajesRepository;

    @Mock
    PersonasService personasService;

    @Mock
    CalculadoraDemora calculadoraDemora;

    @InjectMocks
    ViajesService viajesService;

    public void setUp(){

    }

    @Test
    @DisplayName("Crear Viaje Test")
    public void crearViajeTest(){
        //arrange
        List<Integer> cuidadores = Arrays.asList(1);
        UbicacionDTO origenDTO = new UbicacionDTO("Calle False", 3L, 5L);
        UbicacionDTO destinoDTO = new UbicacionDTO("Calle True", 6L, 9L);

        ViajeDTO viajeDTO = new ViajeDTO(cuidadores, origenDTO, destinoDTO);

        Persona persona = new Persona(3, "Juan", "Perez");
        Persona cuidador = new Persona(1, "Pablo", "Perez");


        Viaje viaje = ViajeMapper.crearViaje(viajeDTO);
        viaje.setPersona(persona);
        viaje.agregarCuidador(cuidador);

        Long duracionEsperada = 2L;
        viaje.setDuracionEstimadaEnMins(duracionEsperada);

        ViajeResponseDTO viajeEsperado = ViajeMapper.crearViajeResponseDTO(viaje);

        //act
        when(personasService.buscarPersonaPorId(3)).thenReturn(persona);
        when(personasService.buscarPersonaPorId(1)).thenReturn(cuidador);
        when(calculadoraDemora.calcularDemoraEntre(viaje.getOrigen(), viaje.getDestino())).thenReturn(duracionEsperada);


        ViajeResponseDTO viajeObtenido = viajesService.crearViaje(viajeDTO, persona.getId());

        //assert
        verify(viajesRepository, atLeastOnce()).guardar(viaje);
        Assertions.assertEquals(viajeEsperado, viajeObtenido);

    }
}
