package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.exceptions.NotFoundException;
import com.viajescuidados.repositories.ViajesRepository;
import com.viajescuidados.services.ViajesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViajesServicesTest {

    @Mock
    ViajesRepository viajesRepository;

    @InjectMocks
    ViajesService viajesServices;

    @Test
    @DisplayName("Buscar viajes por id bad request")
    public void buscar() {
        // arrange
        when(viajesRepository.buscarPorId(1)).thenReturn(Optional.empty());
        // act
        Assertions.assertThrows(NotFoundException.class, () -> viajesServices.comenzarViaje(1));
        //

    }

}
