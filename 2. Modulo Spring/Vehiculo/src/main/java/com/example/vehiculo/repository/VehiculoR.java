package com.example.vehiculo.repository;
import com.example.vehiculo.dot.VehiculoDOT;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
public class VehiculoR implements  IVehiculo{
    public List<VehiculoDOT> obtenerVehiculos(){
        ObjectMapper mapper = new ObjectMapper();
        List<VehiculoDOT> vehiculos = null;
        return vehiculos;
    };

}
