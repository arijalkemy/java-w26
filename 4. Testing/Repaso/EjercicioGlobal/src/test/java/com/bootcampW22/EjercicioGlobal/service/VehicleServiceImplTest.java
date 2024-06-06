package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VehicleServiceImplTest {
    public static final String NO_SE_ENCONTRARON_VEHICULOS_DE_ESA_MARCA = "No se encontraron vehículos de esa marca.";
    public static final String NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS = "No se encontraron vehículos con esos criterios.";
    private final ObjectMapper mapper = new ObjectMapper();

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("Search vehicles by year and color ok test")
    void searchVehiclesByYearAndColorOKTest() {
        // Arrange
        String color = "Mauv";
        int year = 2010;
        List<Vehicle> vehicleEntityList = Collections
                .singletonList(TestUtils.fordFiestaVehicleEntity());

        List<VehicleDto> expectedVehicleDTOList = vehicleEntityList.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .toList();
        when(vehicleRepository.findVehiclesByYearAndColor(color, year))
                .thenReturn(vehicleEntityList);

        // Act
        List<VehicleDto> actualVehicleDTOList = vehicleService.searchVehiclesByYearAndColor(color, year);

        // Assert
        assertEquals(expectedVehicleDTOList, actualVehicleDTOList);
    }

    @Test
    @DisplayName("Search vehicles by year and color not found test")
    void searchVehiclesByYearAndColorNotFoundTest() {
        // Arrange
        String color = "Red";
        int year = 2010;

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(new ArrayList<>());

        // Act & Assert

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByYearAndColor(color, year));

        assertEquals(NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS, exception.getMessage());
    }

    @Test
    @DisplayName("Calculate avg speed by brand OK test")
    void calculateAvgSpeedByBrandOkTest() {
        // Arrange
        String brand = "Lexus";
        String speed = "150";
        List<Vehicle> vehiclesEntityList = Collections
                .singletonList(Vehicle
                        .builder()
                        .max_speed(speed)
                        .build());
        when(vehicleRepository.findVehiclesByBrand(brand))
                .thenReturn(vehiclesEntityList);
        VehicleAvgSpeedByBrandDto expectedResponse = new VehicleAvgSpeedByBrandDto(150.0);

        // Act
        VehicleAvgSpeedByBrandDto actualResponse = vehicleService.calculateAvgSpeedByBrand(brand);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Calculate avg speed by brand not found test")
    void calculateAvgSpeedByBrandNotFoundTest() {
        // Arrange
        String brand = "Lexus";
        List<Vehicle> vehicles = new ArrayList<>();
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicles);

        // Act & assert
        NotFoundException actualException = assertThrows(
                NotFoundException.class,
                () -> vehicleService.calculateAvgSpeedByBrand(brand));
        assertEquals(NO_SE_ENCONTRARON_VEHICULOS_DE_ESA_MARCA, actualException.getMessage());
    }

    @Test
    @DisplayName("Search vehicles by brand and range of year ok test")
    void searchVehiclesByBrandAndRangeOfYearOkTest() {
        // Arrange
        String brand = "Ford";
        int startYear = 2010;
        int endYear = 2020;
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(TestUtils.mitsubishiExcelVehicleEntity());
        vehicles.add(TestUtils.fordFiestaVehicleEntity());
        List<VehicleDto> expectedResponse = TestUtils.mapVehicleEntitiesToDto(vehicles);

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(vehicles);

        // Act
        List<VehicleDto> actualResponse = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Search vehicles by brand and range of year not found")
    void searchVehiclesByBrandAndRangeOfYearNotFoundTest() {
        // Arrange
        String brand = "Honda";
        int startYear = 2010;
        int endYear = 2020;
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear,endYear))
                .thenReturn(new ArrayList<>());

        // Act & assert
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear));
        assertEquals(NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS, exception.getMessage());
    }
}
