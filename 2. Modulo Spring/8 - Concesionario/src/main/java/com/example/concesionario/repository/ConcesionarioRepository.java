package com.example.concesionario.repository;

import com.example.concesionario.entity.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcesionarioRepository implements IConcesionarioRepository{

    private int contadorId;
    private List<Vehiculo> vehiculoList;

    public ConcesionarioRepository(){
        contadorId = 0;
        vehiculoList = new ArrayList<>();
    }

    public Integer crearVehiculo(Vehiculo vehiculo){
        vehiculo.setId(contadorId);
        contadorId++;
        vehiculoList.add(vehiculo);
        return vehiculo.getId();
    }

    @Override
    public List<Vehiculo> buscarTodos() {
        return vehiculoList;
    }

    @Override
    public List<Vehiculo> buscarPorPrecio(double desde, double hasta) {
        return vehiculoList.stream()
                .filter(vehiculo -> (vehiculo.getManufactoringDate().getYear() < hasta && vehiculo.getManufactoringDate().getYear() > desde))
                .toList();
    }

    @Override
    public List<Vehiculo> buscarPorFecha(Integer desde, Integer hasta) {
        return vehiculoList.stream()
                .filter(vehiculo -> (vehiculo.getPrice() < hasta && vehiculo.getPrice() > desde))
                .toList();
    }

    @Override
    public Vehiculo buscarPorId(Integer id) {
        return vehiculoList.stream()
                .filter(vehiculo -> vehiculo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
