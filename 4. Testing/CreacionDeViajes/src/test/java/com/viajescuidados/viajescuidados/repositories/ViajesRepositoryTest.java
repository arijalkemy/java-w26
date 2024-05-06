package com.viajescuidados.viajescuidados.repositories;

import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.mappers.UbicacionMapper;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.repositories.ViajesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViajesRepositoryTest {

    private IViajesRepository viajesRepository;

    @BeforeEach
    void setUp() {
        viajesRepository = new ViajesRepository();
    }

    @Test
    @DisplayName("Se asigna ID 1 al guardar viaje")
    void guardar() {
        Persona persona = Persona.builder()
                .nombre("Franco")
                .apellido("Moises")
                .build();
        Ubicacion ubicacion = UbicacionMapper.crearUbicacion(new UbicacionDTO("", 12L, 12L));
        Viaje viaje = Viaje.builder()
                .persona(persona)
                .origen(ubicacion)
                .destino(ubicacion)
                .build();
        viajesRepository.guardar(viaje);

        assertEquals(1, viaje.getId());


    }

    @Test
    void buscarPorId() {

    }
}