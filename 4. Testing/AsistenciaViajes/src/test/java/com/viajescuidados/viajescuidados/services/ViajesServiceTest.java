package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.repositories.ViajesRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.utils.ubicaciones.CalculadoraDemora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViajesServiceTest {
    @Mock
    IPersonasRepository iPersonasRepository;

    @Mock
    CalculadoraDemora calculadoraDemora;

    @Mock
    private ViajesRepository viajesRepository;

    @Mock
    private PersonasService personasService;
    @InjectMocks
    private ViajesService viajesService;


    @Test
    public void CrearViajeTest() {
        //
        Persona cuidador = new Persona(1, "Pepe", "Garcia");
        Persona solicitante = new Persona(2, "Raul", "Perez");
        //
        when(personasService.buscarPersonaPorId(2)).thenReturn(solicitante);
        when(personasService.buscarPersonaPorId(1)).thenReturn(cuidador);

        UbicacionDTO origenDto = new UbicacionDTO("c", 2L, 2L);
        UbicacionDTO destinoDto = new UbicacionDTO("d", 2L, 2L);

        List<Integer> cuidadores = new ArrayList<>();
        cuidadores.add(1);
        ViajeDTO viajeDTO = new ViajeDTO(cuidadores, origenDto, destinoDto);

        //
        ViajeResponseDTO viajeResponseDTO = ViajeResponseDTO.builder()
                .id(1)
                .personaId(solicitante.getId())
                .cuidadores(cuidadores)
                .origen(origenDto)
                .destino(destinoDto)
                .estado("NO_INICIADO")
                .duracionEstimadaEnMins(2L)
                .fechaComienzo(LocalDateTime.now())
                .fechaFinalizacion(LocalDateTime.now())
                .build();

        when(viajesService.crearViaje(viajeDTO, solicitante.getId())).thenReturn(viajeResponseDTO);
    }
}
