package com.example.concesionaria.repository;

import com.example.concesionaria.model.Services;
import com.example.concesionaria.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{




     private Integer count = 5;
     private List<Services> services = new ArrayList<>();
     private List<Vehicle> vehicleList = new ArrayList<>(){{
         add(new Vehicle(1,"KIA", "Rio", LocalDate.parse("2002-12-03"), 11500.0, 5, 500.0, "AR", services, 5));
         add(new Vehicle(2,"Renault", "Logan", LocalDate.parse("2018-01-21"), 11500.0, 5, 800.0, "AR", services, 5));
         add(new Vehicle(3,"Chevrolet", "Spark", LocalDate.parse("2012-09-20"), 11500.0, 5, 1000.0, "AR", services, 5));
         add(new Vehicle(4,"Mazda", "C3", LocalDate.parse("2020-10-02"), 11500.0, 5, 100.0, "AR", services, 5));
     }};


//     public void fillVehicleList() {
//         vehicleList.add(new Vehicle(1,"KIA", "Rio", LocalDate.parse("2002-12-03"), 11500.0, 5, 500.0, "AR", services, 5));
//         vehicleList.add(new Vehicle(2,"Renault", "Logan", LocalDate.parse("2018-01-21"), 11500.0, 5, 800.0, "AR", services, 5));
//         vehicleList.add(new Vehicle(3,"Chevrolet", "Spark", LocalDate.parse("2012-09-20"), 11500.0, 5, 1000.0, "AR", services, 5));
//         vehicleList.add(new Vehicle(4,"Mazda", "C3", LocalDate.parse("2020-10-02"), 11500.0, 5, 100.0, "AR", services, 5));
//
//     }


    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> getAllVehiclesByDate(Integer sinceDate, Integer toDate) {
        return vehicleList.stream()
                .filter(v -> (v.getManufacturingDate().getYear()>sinceDate && v.getManufacturingDate().getYear()< toDate))
                .toList();
    }

    @Override
    public List<Vehicle> getAllVehiclesByPrice(Double sincePrice, Double toPrice) {
        return vehicleList.stream()
                .filter(v -> (v.getPrice()>sincePrice && v.getPrice()<toPrice))
                .toList();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleList.stream()
                .filter(v -> v.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Integer createVehicle(Vehicle vehicle) {
        vehicle.setId(count++);
        vehicleList.add(vehicle);
        return this.count;
    }

}
