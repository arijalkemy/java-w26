package com.example._6_persona_practicatestyvalidaciones.service;

import com.example._6_persona_practicatestyvalidaciones.dto.requestDTO.DeporteRequestDTO;
import com.example._6_persona_practicatestyvalidaciones.dto.responseDTO.DeporteResponseDTO;
import com.example._6_persona_practicatestyvalidaciones.model.Deporte;
import com.example._6_persona_practicatestyvalidaciones.repository.DeporteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DeporteServiceTest {
    @Mock
    DeporteRepository repository;

    @InjectMocks
    DeporteService service;

    private DeporteRequestDTO generarRequestDTO(){
        return DeporteRequestDTO.builder().nombre("Futbol").nivel(9).build();
    }

    DeporteResponseDTO generarResponseDTO(){
        return DeporteResponseDTO.builder().nombre("Futbol").nivel(9).build();
    }

    @Test
    @DisplayName("Deporte cargado correctamente")
    public void deporteAgregadoOk(){
        ObjectMapper mapper = new ObjectMapper();
        Deporte deporte = mapper.convertValue(generarRequestDTO(), Deporte.class);

        when(repository.save(deporte)).thenReturn(deporte);
        DeporteResponseDTO deporteObtained = service.agregarDeporte(generarRequestDTO());

        verify(repository).save(deporte);

        Assertions.assertEquals(generarResponseDTO(), deporteObtained);
    }

}
