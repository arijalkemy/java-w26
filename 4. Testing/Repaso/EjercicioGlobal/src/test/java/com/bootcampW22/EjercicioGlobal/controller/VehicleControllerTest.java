package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleControllerTest {
    public static final String NO_SE_ENCONTRARON_VEHÍCULOS_DE_ESA_MARCA = "No se encontraron vehículos de esa marca.";
    public static final String NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS = "No se encontraron vehículos con esos criterios.";
    @Mock
    VehicleServiceImpl vehicleService;

    @InjectMocks
    VehicleController vehicleController;

    @Test
    @DisplayName("Get vehicles by color and year ok test")
    void getVehiclesByColorAndYearOkTest() {
        // Arrange
        String color = "Mauv";
        int year = 1970;
        List<VehicleDto> expectedList = Collections
                .singletonList(TestUtils.fordFiestaVehicleDto());
        when(vehicleService.searchVehiclesByYearAndColor(color, year)).thenReturn(expectedList);
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedList, HttpStatus.OK);

        // Act
        ResponseEntity<?> actualResponse = vehicleController.getVehiclesByColorAndYear(color, year);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get vehicles by color and year not found test")
    void getVehiclesByColorAndYearNotFoundTest() {
        // Arrange
        String color = "Red";
        int year = 2010;
        when(vehicleService.searchVehiclesByYearAndColor(color, year))
                .thenThrow(new NotFoundException(NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS));

        // Act
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleController.getVehiclesByColorAndYear(color, year));

        // Assert
        assertEquals(exception.getMessage(), NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS);
    }

    @Test
    @DisplayName("Get avg speed by brand ok test")
    void getAverageSpeedByBrandOKTest() {
        // Arrange
        String brand = "Lexus";
        VehicleAvgSpeedByBrandDto expectedResponseDto = new VehicleAvgSpeedByBrandDto(150.0);
        when(vehicleService.calculateAvgSpeedByBrand(brand))
                .thenReturn(expectedResponseDto);
        ResponseEntity<?> expectedResponse =
                new ResponseEntity<>(expectedResponseDto, HttpStatus.OK);

        // Act
        ResponseEntity<?> actualResponse = vehicleController.getAverageSpeedByBrand(brand);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get avg speed by brand not found test")
    void getAverageSpeedByBrandNotFoundTest() {
        // Arrange
        String brand = "Lexus";
        when(vehicleService.calculateAvgSpeedByBrand(brand))
                .thenThrow(new NotFoundException(NO_SE_ENCONTRARON_VEHÍCULOS_DE_ESA_MARCA));

        // Act & Asssert
        NotFoundException actualException = assertThrows(NotFoundException.class,
                () -> vehicleController.getAverageSpeedByBrand(brand));
        assertEquals(NO_SE_ENCONTRARON_VEHÍCULOS_DE_ESA_MARCA, actualException.getMessage());
    }

    @Test
    @DisplayName("Get vehicles by brand and range of year Ok test")
    void getVehiclesByBrandAndRangeOfYearOkTest() {
        // Arrange
        String brand = "Falcon";
        int startYear = 1950;
        int endYear = 1980;
        List<VehicleDto> expectedVehicleList = Collections
                .singletonList(TestUtils.fordFiestaVehicleDto());
        when(vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(expectedVehicleList);
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedVehicleList, HttpStatus.OK);

        // Act
        ResponseEntity<?> actualResponse = vehicleController.getVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Get vehicles by brand and range of year not found test")
    void getVehiclesByBrandAndRangeOfYearNotFoundTest() {
        // Arrange
        String brand = "Falcon";
        int startYear = 1950;
        int endYear = 1980;
        when(vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenThrow(new NotFoundException(NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS));

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                vehicleController.getVehiclesByBrandAndRangeOfYear(brand, startYear, endYear));
        assertEquals(NO_SE_ENCONTRARON_VEHICULOS_CON_ESOS_CRITERIOS, exception.getMessage());
    }
}
