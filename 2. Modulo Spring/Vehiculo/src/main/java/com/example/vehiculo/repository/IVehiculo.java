package com.example.vehiculo.repository;
import com.example.vehiculo.dot.VehiculoDOT;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVehiculo {
    public List<VehiculoDOT> getAllVehiculos();
}
