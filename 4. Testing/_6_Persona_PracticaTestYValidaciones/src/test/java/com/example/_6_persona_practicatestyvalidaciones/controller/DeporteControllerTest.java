package com.example._6_persona_practicatestyvalidaciones.controller;

import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.dto.responseDTO.DeporteResponseDTO;
import com.example._6_persona_practicatestyvalidaciones.service.DeporteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static  org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
public class DeporteControllerTest {
    @Mock
    DeporteService service;

    @InjectMocks
    DeporteController controller;

    private DeporteRequestDTO generarRequestDTO(){
        return DeporteRequestDTO.builder().nombre("Futbol").nivel(9).build();
    }

    private DeporteResponseDTO generarResponseDTO(){
        return DeporteResponseDTO.builder().nombre("Futbol").nivel(9).build();
    }

    @Test
    @DisplayName("Llama correctamente al service y obtiene un resultado satisfactorio")
    public void agregarDeporteOk() {
        DeporteRequestDTO deporte = generarRequestDTO();
        DeporteResponseDTO responseDTOEsperado = generarResponseDTO();

        when(service.agregarDeporte(deporte)).thenReturn(generarResponseDTO());

        DeporteResponseDTO responseDTO = controller.service.agregarDeporte(deporte);

        verify(service).agregarDeporte(deporte);

        assertEquals(responseDTOEsperado, responseDTO);
    }
}
