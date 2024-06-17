package com.bootcampW22.EjercicioGlobal.repository;

import org.apache.commons.collections4.CollectionUtils;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.io.IOException;

import java.util.List;

public class VehicleRepositoryTest {

    VehicleRepositoryImpl vehicleRepository;
    private List<Vehicle> vehicleList;
    @BeforeEach
    public void setUp() throws IOException {
        this.vehicleRepository = new VehicleRepositoryImpl();
        vehicleList= TestUtilsGenerator.loadDataBase();
    }

    @Test
    public void findAllTest() throws IOException {
        List<Vehicle> vehicleListFound=  vehicleRepository.findAll();
        Assertions.assertTrue(CollectionUtils.isEqualCollection(vehicleList,vehicleListFound));
    }
    @Test
    public void findVehiclesByYearAndColorTest() throws IOException {
        String color= "Violet";
        int year=1984;
        List<Vehicle> vehicleListResult= vehicleRepository.findVehiclesByYearAndColor(color,year);
        Assertions.assertTrue(vehicleListResult.get(0).getColor().equalsIgnoreCase(color));
        Assertions.assertTrue(vehicleListResult.get(0).getYear()==year);
    }

    @Test
    public void findVehiclesByBrandAndRangeOfYearTest() throws IOException {
        String brand="Pontiac";
        int start_year=1986;
        int end_year=1987;
        List<Vehicle> vehicleListResult= vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year);
        Assertions.assertTrue(vehicleListResult.get(0).getBrand().equalsIgnoreCase(brand));
        Assertions.assertTrue(vehicleListResult.get(0).getYear()>= start_year
                && vehicleListResult.get(0).getYear()<= end_year);
    }
    @Test
    public void findVehiclesByBrandTest() throws IOException{
        String brand="Ford";
        List<Vehicle> vehicleListResult= vehicleRepository.findVehiclesByBrand(brand);
        Assertions.assertTrue(vehicleListResult.get(0).getBrand().equalsIgnoreCase(brand));
    }

    @Test
    public void findVehiclesByRangeOfWeightTest() throws IOException{
        double weight_min=288.8;
        double weight_max=290;
        List<Vehicle> vehicleListResult= vehicleRepository.findVehiclesByRangeOfWeight(weight_min,weight_max);
        Assertions.assertTrue((vehicleListResult.get(0).getWeight()>=weight_min)
                && (vehicleListResult.get(0).getWeight()<=weight_max));
    }

}
