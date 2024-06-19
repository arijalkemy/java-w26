package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {
    @Mock
    VehicleServiceImpl service;
    @InjectMocks
    VehicleController controller;
    static List<VehicleDto> listDto;

    @BeforeAll
    static void initList(){
        listDto = Arrays.asList(
                new VehicleDto(1L, "Tesla", "Model S", "XYZ789", "Black", 2022,
                        "250", 5, "Electric", "Automatic",
                        1.44, 1.85, 2100),
                new VehicleDto(2L, "Toyota", "Camry", "ABC123", "Silver", 2020,
                        "220", 5, "Gasoline", "Automatic", 1.46,
                        1.82, 1500),
                new VehicleDto(3L, "Honda", "Accord", "DEF456", "Blue", 2021,
                        "230", 5, "Gasoline",
                        "Automatic", 1.42, 1.85, 1550)
        );
    }

    @Test
    @DisplayName("Controller devuelve corrrectamente promedio de velocidad ")
   void getAvgBySpeed(){
        //arrange
        VehicleAvgSpeedByBrandDto expect = new VehicleAvgSpeedByBrandDto(255.5);

        when(service.calculateAvgSpeedByBrand(anyString())).thenReturn(expect);
        //act
        ResponseEntity<?> response = controller.getAverageSpeedByBrand("any");
        //asert
        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.hasBody());
        assertTrue(response.getBody().equals(expect));

    }
}
