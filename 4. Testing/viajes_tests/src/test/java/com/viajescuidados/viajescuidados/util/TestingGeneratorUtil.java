package com.viajescuidados.viajescuidados.util;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.dtos.responses.ViajeResponseDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.viajes.EstadoViaje;

public class TestingGeneratorUtil {

    public static ViajeDTO crateViajeDTO() {
        List<Integer> cuidadores = List.of(1, 2);
        return new ViajeDTO(cuidadores, crearUbicacion("A", 1, 1), crearUbicacion("B", 2, 2));
    }

    public static UbicacionDTO crearUbicacion(String dir, long latitud, long longitud) {
        return new UbicacionDTO(dir, latitud, longitud);
    }

    public static Persona crearPersona(int id, String tipo) {
        return new Persona(id, "Test ", "Unitario " + tipo);
    }

    public static ViajeResponseDTO createViajeResponseWithDef() {
        ViajeDTO dto = crateViajeDTO();
        return ViajeResponseDTO.builder()
                .id(1)
                .origen(dto.getOrigen())
                .destino(dto.getDestino())
                .personaId(3)
                .cuidadores(List.of(1, 2))
                .estado(EstadoViaje.NO_INICIADO.toString())
                .duracionEstimadaEnMins(2L)
                .build();
    }

}
