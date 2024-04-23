package com.example.concesionario.repository;

import com.example.concesionario.entity.Vehiculo;

import java.util.List;

public interface IConcesionarioRepository {

    public Integer crearVehiculo(Vehiculo vehiculo);

    public List<Vehiculo> buscarTodos();

    public List<Vehiculo> buscarPorPrecio(double desde, double hasta);

    public List<Vehiculo> buscarPorFecha(Integer desde, Integer hasta);

    public Vehiculo buscarPorId(Integer id);
}
