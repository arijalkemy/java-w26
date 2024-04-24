package com.autos.concesionaria.repository;

import com.autos.concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioVehiculosImpl implements IRepositorioVehiculos{

    private static List<Vehiculo> listaVehiculos = new ArrayList<>();

    @Override
    public List<Vehiculo> mostrarListaVehiculos() {
        return listaVehiculos;
    }

    @Override
    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }


}
