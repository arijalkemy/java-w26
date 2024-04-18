package com.autos.concesionaria.repository;

import com.autos.concesionaria.entity.Vehiculo;
import java.util.List;

public interface IRepositorioVehiculos {
    public List<Vehiculo> mostrarListaVehiculos();

    public void agregarVehiculo(Vehiculo vehiculo);
}
