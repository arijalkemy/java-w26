package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {
    static List<Vehicle> listOfVehicles = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();

    public static List<Vehicle> loadDataBase() throws IOException {
        File file;
        List<Vehicle> vehicles ;
        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= mapper.readValue(file,new TypeReference<List<Vehicle>>(){});
        listOfVehicles = vehicles;
        return listOfVehicles;
    }

    public static List<VehicleDto> getAllVehiclesDto() throws IOException {
        return loadDataBase().stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .toList();
    }

    public static List<VehicleDto> getFourVehiclesDto(){
        VehicleDto vehicle1 = new VehicleDto(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180 km/h", 5, "Petrol", "Automatic", 1.45, 1.75, 1300);
        VehicleDto vehicle2 = new VehicleDto(2L, "Honda", "Civic", "DEF456", "Blue", 2019, "200 km/h", 5, "Petrol", "Manual", 1.42, 1.80, 1250);
        VehicleDto vehicle3= new VehicleDto(3L, "Ford", "Mustang", "GHI789", "Black", 2021, "250 km/h", 4, "Petrol", "Automatic", 1.38, 1.91, 1650);
        VehicleDto vehicle4 = new VehicleDto(4L, "Tesla", "Model S", "JKL012", "White", 2022, "250 km/h", 5, "Electric", "Automatic", 1.44, 1.96, 2000);

        return List.of(vehicle1,vehicle2,vehicle3,vehicle4);
    }
    public static List<Vehicle> getTwoVehiclesSameBrand(){
        Vehicle vehicle1 = new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180", 4, "Petrol", "Automatic", 1.45, 1.75, 1300);
        Vehicle vehicle2 = new Vehicle(2L,"Toyota", "Camry", "XYZ789", "Blue", 2021, "210", 2, "Hybrid", "Automatic", 1.47, 1.82, 1500);

        return List.of(vehicle1,vehicle2);
    }
}
