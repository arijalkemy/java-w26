package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

    @Mock
    VehicleServiceImpl vehicleService;

    @InjectMocks
    VehicleController vehicleController;

    @Test
    public void  getVehiclesTest(){
        //arrange
        List<VehicleDto> vehicleDtoList= TestUtilsGenerator.getFourVehiclesDto();

        Mockito.when(vehicleService.searchAllVehicles()).thenReturn(vehicleDtoList);

        //act
        Integer statusCode= vehicleController.getVehicles().getStatusCode().value();

        //Assertions
        Assertions.assertEquals(statusCode,200);


    }
}
