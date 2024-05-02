package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.services.utils.ubicaciones.ICalculadoraDemora;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculadoraDemoraTest {

    @Autowired
    private ICalculadoraDemora calculadoraDemora;

    @Test
    void calcularDemoraEntreTest() {
        // Act
        long result = calculadoraDemora.calcularDemoraEntre(
            new Ubicacion(
                    "Calle 123",
                    4L,
                    6L
            ),
            new Ubicacion(
                    "Calle 123",
                    12L,
                    10L
            )
        );

        // Assert
        assertEquals(result, 2L);
    }
}
