package com.autos.concesionaria.service;

import com.autos.concesionaria.dto.VehiculoDTO;
import com.autos.concesionaria.entity.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IVehiculoService {

    public void agregarVehiculo(Vehiculo vehiculo);

    public List<VehiculoDTO> mostrarVehiculosUsados();

    public List<Vehiculo> mostrarVehiculoPorFecha(LocalDate inicio, LocalDate fin);

    public List<Vehiculo> mostrarVehiculoPorPrecio(Integer inicio, Integer fin);

    public Vehiculo mostrarVehiculoPorId(Integer id);
}
