package com.viajescuidados.viajescuidados.controller;

import com.viajescuidados.controllers.ViajesController;
import com.viajescuidados.dtos.UbicacionDTO;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.services.ViajesService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ViajesControllerTest {
  @Mock
  private ViajesService viajesService;

  @InjectMocks
  private ViajesController viajesController;

  @Test
  public void crearUnViajeTest() {
    // Arrange
    ViajeDTO viajeDTO = new ViajeDTO(List.of(1, 2, 3), new UbicacionDTO(), new UbicacionDTO());

    // Act

    // Assert

  }
}
