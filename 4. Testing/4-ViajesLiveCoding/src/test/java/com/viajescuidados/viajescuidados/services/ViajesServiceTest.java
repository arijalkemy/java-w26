package com.viajescuidados.viajescuidados.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.UbicacionMapper;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ViajesServiceTest {
    ObjectMapper mapper = new ObjectMapper();
    @Mock
    private IViajesRepository viajesRepository;
    @Mock
    private IPersonaServiceInternal personaService;
    @Mock
    private ICalculadoraDemora calculadorDemora;
    @InjectMocks
    private ViajesService viajesService;

    @Test
    public void crearViajeTest() {
        // Arrange
        UbicacionDTO origen = new UbicacionDTO("origen", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("destino", (long) -34.5, (long) -59);
        Integer id = 1;
        ViajeDTO viajeDTO = new ViajeDTO(List.of(2, 3), origen, destino);
        Viaje viaje = ViajeMapper.crearViaje(viajeDTO);
        Persona personaUno = new Persona(1, "Silva", "Di Marco");
        Persona personaDos = new Persona(2, "Lucas", "Sanchez");
        Persona personaTres = new Persona(3, "Maca", "Del Valle");

        when(personaService.buscarPersonaPorId(1)).thenReturn(personaUno);
        when(personaService.buscarPersonaPorId(2)).thenReturn(personaDos);
        when(personaService.buscarPersonaPorId(3)).thenReturn(personaTres);
        when(this.calculadorDemora
            .calcularDemoraEntre(
                viaje.getOrigen(),
                viaje.getDestino()
            )
        ).thenReturn(10L);

        // Act
        ViajeResponseDTO respuesta = viajesService.crearViaje(viajeDTO, id);

        // Assert
        verify(viajesRepository, atLeastOnce()).guardar(any());
        Assertions.assertEquals(10L, respuesta.getDuracionEstimadaEnMins());
        Assertions.assertEquals(personaUno.getId(), respuesta.getPersonaId());
        Assertions.assertTrue(respuesta.getCuidadores().contains(2));
        Assertions.assertTrue(respuesta.getCuidadores().contains(3));
    }
}
