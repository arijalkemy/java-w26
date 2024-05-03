package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.ViajeMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViajesServiceTests {

    /*@Mock
    IViajesRepository viajesRepository;

    @Mock
    IPersonaServiceInternal personasService;

    @Mock
    ICalculadoraDemora calculadoraDemora;

    @InjectMocks
    ViajesService viajesService;

    @Test
    @Disabled
    public void crearViajeTest() {
        Persona persona = new Persona(1, "Juan", "Perez");
        when(personasService.buscarPersonaPorId(1)).thenReturn(persona);
        Persona cuidador = new Persona(2, "Carlos", "Gomez");
        List<Integer> cuidadores = List.of(2);

        UbicacionDTO origen = new UbicacionDTO("", (long) -34.5, (long) -58.5);
        UbicacionDTO destino = new UbicacionDTO("", (long) -34.5, (long) -59);
        ViajeDTO viajeDTO = new ViajeDTO(cuidadores, origen, destino);
        Viaje viaje = ViajeMapper.crearViaje(viajeDTO);

        ViajeResponseDTO viajeEsperado = new ViajeResponseDTO();

        when(viajesRepository.guardar(viaje)).thenReturn(1);




    }*/


}
