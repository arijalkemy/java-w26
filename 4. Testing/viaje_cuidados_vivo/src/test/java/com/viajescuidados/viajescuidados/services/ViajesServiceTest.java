package com.viajescuidados.viajescuidados.services;
import com.viajescuidados.entities.viajes.Viaje;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.repositories.IViajesRepository;
import com.viajescuidados.services.ViajesService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
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
public class ViajesServiceTest {

    @Mock
    private IViajesRepository viajesRepository;
    @Mock
    private IPersonaServiceInternal personaService;
    @Mock
    private ICalculadoraDemora calculadorDemora;

    @InjectMocks
    private ViajesService viajesService;

    @Test
    @DisplayName("Buscar viaje por ID existente")
    public void buscarViajePorIdExistenteTest() {
       // Mock de un viaje existe
       Viaje viajeMock = new Viaje();
       viajeMock.setId(1);
       viajeMock.setEstado(EstadoViaje.NO_INICIADO);

       // Mockeando el repo para retornar un viaje existe
       when(viajesRepository.buscarPorId(1)).thenReturn(Optional.of(viajeMock));

       Viaje respuesta = viajesService.buscarViajePorId(1);

       // Asserts
        Assertions.assertEquals(viajeMock.getId(), respuesta.getId());
    }
}