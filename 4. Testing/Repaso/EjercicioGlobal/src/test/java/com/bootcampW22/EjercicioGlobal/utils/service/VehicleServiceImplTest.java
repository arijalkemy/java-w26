package com.bootcampW22.EjercicioGlobal.utils.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceImplTest {
    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;
    @Test()
    @DisplayName("Search by range of weight ok test")
    void searchVehiclesByRangeOfWeightOkTest() {
        // Arrange
        double minWeight = 200.0;
        double maxWeight = 300.0;
        List<Vehicle> expectedVehiclesEntity = new ArrayList<>();
        expectedVehiclesEntity.add(TestUtils.fordFiestaVehicleEntity());
        List<VehicleDto> expectedResult = TestUtils.mapVehicleEntitiesToDto(expectedVehiclesEntity);

        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight)).thenReturn(expectedVehiclesEntity);

        // Act
        List<VehicleDto> actualResult = vehicleService.searchVehiclesByRangeOfWeight(minWeight, maxWeight);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test()
    @DisplayName("Search by range of weight not found test")
    void searchVehiclesByRangeOfWeightNotFoundTest() {
        // Arrange
        double minWeight = 200.0;
        double maxWeight = 300.0;
        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight)).thenReturn(new ArrayList<>());

        // Act & assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByRangeOfWeight(minWeight, maxWeight));
        assertEquals(exception.getMessage(), "No se encontraron vehículos en ese rango de peso.");
    }
}
