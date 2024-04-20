package com.sinc_ejercicioconcesionaria.repositorio;

import com.sinc_ejercicioconcesionaria.entidad.ServiceVehiculo;
import com.sinc_ejercicioconcesionaria.entidad.Vehiculo;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositorioVehiculo {

    public static List<Vehiculo> listaVehiculos = new ArrayList<>();
    public static List<ServiceVehiculo> listaServiceVehiculos = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public void agregarService(ServiceVehiculo serviceVehiculo) {
        listaServiceVehiculos.add(serviceVehiculo);
    }

}
