package com.example._6_persona_practicatestyvalidaciones.repository;

import com.example._6_persona_practicatestyvalidaciones.model.Deporte;
import com.example._6_persona_practicatestyvalidaciones.utils.JSONUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DeporteRepositoryTest {
    @Mock
    private JSONUtils jsonUtilsMock;
    @InjectMocks
    DeporteRepository repository;

    @Test
    @DisplayName("Cargado correctamente")
    public void deporteAgregadoOk(){
        // Mockeo el comportamiento de JSONUtils para que no guarde realmente en el archivo
        Mockito.doNothing().when(jsonUtilsMock).saveListToFile(anyString(), anyList());

        Deporte deporte = generarDeporte();
        Deporte resultado = repository.save(deporte);

        assertEquals(deporte, resultado);

        // Verifico que se llama al método saveListToFile de JSONUtils con el nombre de archivo correcto y la lista de deportes
        Mockito.verify(jsonUtilsMock).saveListToFile(eq("deporteTest.json"), anyList());
    }

    Deporte generarDeporte(){
        return new Deporte("futbol",9);
    }
}
