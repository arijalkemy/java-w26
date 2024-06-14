package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    public void searchAllVehiclesTest() throws IOException {
        //arrange
        List<VehicleDto> vehicleDtosExpected= TestUtilsGenerator.getAllVehiclesDto();
        List<Vehicle> vehicleRepositoryResult = TestUtilsGenerator.loadDataBase();
        //act

        Mockito.when(vehicleRepository.findAll()).thenReturn(vehicleRepositoryResult);
        List<VehicleDto> vehicleDtosResult= vehicleService.searchAllVehicles();
        //assertions
        verify(vehicleRepository, atLeastOnce()).findAll();

        Assertions.assertTrue(CollectionUtils.isEqualCollection(vehicleDtosExpected,vehicleDtosResult));
    }

    @Test
    public void calculateAvgSpeedByBrandTest(){
        //Arrange
        String brand= "Toyota";
        VehicleAvgSpeedByBrandDto vehicleAvgSpeedByBrandDtoExpected= new VehicleAvgSpeedByBrandDto(195.0);
        List<Vehicle> vehicleRepositoryResult = TestUtilsGenerator.getTwoVehiclesSameBrand();

        //act
        Mockito.when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleRepositoryResult);
        VehicleAvgSpeedByBrandDto vehicleAvgSpeedByBrandDtoResult= vehicleService.calculateAvgSpeedByBrand(brand);

        //assertions
        verify(vehicleRepository, atLeastOnce()).findVehiclesByBrand(brand);

        Assertions.assertEquals(vehicleAvgSpeedByBrandDtoExpected,vehicleAvgSpeedByBrandDtoResult);
    }

    @Test
    public void calculateAvgCapacityByBrandTest(){
        //Arrange
        String brand= "Toyota";
        VehicleAvgCapacityByBrandDto vehicleAvgCapacityByBrandDtoExpected= new VehicleAvgCapacityByBrandDto(3);
        List<Vehicle> vehicleRepositoryResult = TestUtilsGenerator.getTwoVehiclesSameBrand();
        //act
        Mockito.when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleRepositoryResult);

        VehicleAvgCapacityByBrandDto vehicleAvgCapacityByBrandDtoResult= vehicleService.calculateAvgCapacityByBrand(brand);

        //assertions
        verify(vehicleRepository, atLeastOnce()).findVehiclesByBrand(brand);
        Assertions.assertEquals(vehicleAvgCapacityByBrandDtoExpected,vehicleAvgCapacityByBrandDtoResult);
    }

    @Test
    public void calculateAvgCapacityByBrandTestSadPath() {
        //arrange
        String brand= "Toyota";
        List<Vehicle> vehicleListEmpty= new ArrayList<>();
        Mockito.when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleListEmpty);

        //act & assert
        Assertions.assertThrows(NotFoundException.class,()-> vehicleService.calculateAvgCapacityByBrand(brand) );
    }





}
