package com.example.seguros.repository;

import com.example.seguros.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("FROM Vehicle")
    List<Vehicle> getAllVehicles();

}
