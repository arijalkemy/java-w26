package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class vehicleServiceTest {
    @InjectMocks
     VehicleServiceImpl service;
    @Mock
    VehicleRepositoryImpl repo ;
    static List<Vehicle> listV ;
    @BeforeAll
    static void initList(){
        //declaracion de lista de prueva promedio de passanger 5, velocidad 200
       listV = Arrays.asList(
        new Vehicle(1L, "Tesla", "Model S", "XYZ789", "Black", 2022,
                "150", 5, "Electric", "Automatic",
                1.44, 1.85, 2100),
                new Vehicle(2L, "Toyota", "Camry", "ABC123", "Silver", 2020,
                        "220", 5, "Gasoline", "Automatic", 1.46,
                        1.82, 1500),
                new Vehicle(3L, "Honda", "Accord", "DEF456", "Blue", 2021,
                        "230", 5, "Gasoline",
                        "Automatic", 1.42, 1.85, 1550)
        );
    }

    @Test
    @DisplayName("Encuentra Auto por color y año (Blue y 2021)")
    void getByYearAndColorOk(){
        //arrange
        when(repo.findVehiclesByYearAndColor(anyString(),anyInt())).thenReturn(
                listV.stream().filter(v -> {return (v.getColor()=="Blue"
                                && v.getYear()==2021);})
                        .toList());
        //act
        List<VehicleDto> vehiclesDto = service.searchVehiclesByYearAndColor("Blue",2021);
        //assert
        assertEquals(vehiclesDto.get(0).getColor(), "Blue");
    }
    @Test
    @DisplayName("No encuentra Auto por color y año (Red y 2019)")
    void getByYearAndColorNotFound(){
        //arrange
        when(repo.findVehiclesByYearAndColor(anyString(),anyInt())).thenReturn(
                listV.stream().filter(v -> {return (v.getColor()=="red"
                                && v.getYear()==2019);})
                        .toList());
        //act
        //assert
        assertThrows(NotFoundException.class, ()-> service.searchVehiclesByYearAndColor("Red", 2019));
    }
    @Test
    @DisplayName("encuentra vehiculo por marca y rango de años (tesla entre 2019 y 2023)")
    void getByBrandAndYearsOk(){
        //arrange
        List<Vehicle> repoResponse = listV.stream().filter(v->{
           return((v.getBrand()=="Tesla") && (2019<= v.getYear()) && v.getYear()<=2023);
        }).toList();
        when(repo.findVehiclesByBrandAndRangeOfYear(anyString(),anyInt(),anyInt())).thenReturn(repoResponse);
        //act
        List<VehicleDto> dtos = service.searchVehiclesByBrandAndRangeOfYear("Tesla", 2019, 2023);
        //assert
        for(VehicleDto v : dtos){
            assertTrue(2019<v.getYear() && v.getYear()<2023);
            assertEquals(v.getBrand(),"Tesla");
        }
    }
    @Test
    @DisplayName("No encuentra por marca y rango de años (Fiat entre 1980 y 2000)")
    void getByBrandAndYeasNotFound(){
        //arrange
        List<Vehicle> repoResponse = List.of();
        //act
        when(repo.findVehiclesByBrandAndRangeOfYear(anyString(),anyInt(),anyInt())).thenReturn(repoResponse);
        //assert
        assertThrows(NotFoundException.class, ()->service.searchVehiclesByBrandAndRangeOfYear("Fiat",
                1980,2020));
    }
    //tercer punto: velocidad promedio por marca
    @Test
    @DisplayName("calcula corrrectamente por marca")
    void getAvgSpeedOk(){
        //arrange
        double expect = 200.0;
        when(repo.findVehiclesByBrand(anyString())).thenReturn(listV);
        //act
        VehicleAvgSpeedByBrandDto obtain = service.calculateAvgSpeedByBrand("tesla");
        //asert
        assertEquals(expect, obtain.getAverage_speed());
    }

    @Test
    @DisplayName("No obtiene nada buscando por marca ")
    void getAvgSpeedNotFound(){
        //arrange
        List<Vehicle> repoResponse = List.of();
        when(repo.findVehiclesByBrand(anyString())).thenReturn(repoResponse);
        //act & act
        assertThrows(NotFoundException.class, ()-> service.calculateAvgSpeedByBrand("Fiat"));
    }

    @Test
    @DisplayName("calcula correctamente promedio pasajeros")
    void getAvgPassangerOk(){
        //arrange
        VehicleAvgCapacityByBrandDto  expect = new VehicleAvgCapacityByBrandDto(5.0);
        when(repo.findVehiclesByBrand(anyString())).thenReturn(listV);
        //act
        VehicleAvgCapacityByBrandDto response = service.calculateAvgCapacityByBrand("Any");
        //assert
        assertEquals(expect,response);
    }
    @Test
    @DisplayName("No puede calcular promedio de pasajeros")
    void getAvgPassangerNotFound(){
        //arrange
        when(repo.findVehiclesByBrand(anyString())).thenReturn(List.of());
        //act
        assertThrows(NotFoundException.class, ()-> service.calculateAvgCapacityByBrand("any"));
    }

}
