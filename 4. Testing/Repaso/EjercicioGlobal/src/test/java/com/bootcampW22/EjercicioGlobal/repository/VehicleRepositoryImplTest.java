package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VehicleRepositoryImplTest {
    @Autowired
    VehicleRepositoryImpl vehicleRepository;

    @Test
    @DisplayName("Should find vehicles by year and color")
    void findVehiclesByYearAndColorOkTest() {
        // Arrange
        String color = "Mauv";
        int year = 2014;
        List<Vehicle> expectedVehicles = Collections.singletonList(TestUtils.fordFiestaVehicleEntity());

        // Act
        List<Vehicle> actualVehicles = vehicleRepository.findVehiclesByYearAndColor(color, year);

        // Assert
        assertEquals(expectedVehicles, actualVehicles);
    }

    @Test
    @DisplayName("Should return empty list if there are no matches")
    void findVehiclesByYearAndColorEmptyTest() {
        // Arrange
        String color = null;
        int year = 2010;

        // Act
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByYearAndColor(color, year);

        // Assert
        assertEquals(vehicles.size(), 0);
    }
}
