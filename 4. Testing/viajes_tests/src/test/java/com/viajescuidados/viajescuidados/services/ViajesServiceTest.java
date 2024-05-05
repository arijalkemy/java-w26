package com.viajescuidados.viajescuidados.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import com.viajescuidados.viajescuidados.util.TestingGeneratorUtil;

@ExtendWith(MockitoExtension.class)
public class ViajesServiceTest {

    @Mock
    private IViajesRepository viajesRepoMock;

    @Mock
    private IPersonaServiceInternal personaServiceMock;

    @Mock
    private ICalculadoraDemora calculadoraMock;

    @InjectMocks
    private ViajesService underTest;

    @Test
    void crearViajeOk() {
        ViajeDTO viajeDto = TestingGeneratorUtil.crateViajeDTO();
        int personaId = 3;
        Persona cuidadorMockDos = TestingGeneratorUtil.crearPersona(2, "Cuidador");
        Persona cuidadorMock = TestingGeneratorUtil.crearPersona(1, "Cuidador");
        Persona personaMock = TestingGeneratorUtil.crearPersona(personaId, "A Cuidar");
        mockearPersonas(List.of(cuidadorMock, cuidadorMockDos, personaMock));
        when(calculadoraMock.calcularDemoraEntre(any(), any())).thenReturn(3L);
        ViajeResponseDTO expected = ViajeResponseDTO.builder()
                .personaId(personaId)
                .origen(viajeDto.getOrigen())
                .destino(viajeDto.getDestino())
                .cuidadores(List.of(1, 2))
                .duracionEstimadaEnMins(3L)
                .build();

        ViajeResponseDTO result = underTest.crearViaje(viajeDto, personaId);

        verify(viajesRepoMock, times(1)).guardar(any());

        assertEquals(expected.getPersonaId(), result.getPersonaId()); 
        assertEquals(expected.getOrigen(), result.getOrigen());
        assertEquals(expected.getDestino(), result.getDestino());
        assertEquals(expected.getCuidadores(), result.getCuidadores()); 
        assertEquals(expected.getDuracionEstimadaEnMins(), result.getDuracionEstimadaEnMins());

    }

    private void mockearPersonas(List<Persona> personas) {
        personas.forEach((persona) -> when(personaServiceMock.buscarPersonaPorId(persona.getId())).thenReturn(persona));
    }

}
