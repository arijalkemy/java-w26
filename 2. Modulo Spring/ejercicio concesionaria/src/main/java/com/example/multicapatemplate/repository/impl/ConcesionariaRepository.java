package com.example.multicapatemplate.repository.impl;

import com.example.multicapatemplate.model.Vehiculo;
import com.example.multicapatemplate.repository.IConcesionariaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConcesionariaRepository implements IConcesionariaRepository {
    List<Vehiculo> vehiculos = new ArrayList<>();

    @Override
    public List<Vehiculo> getAll() {
        return vehiculos;
    }

    @Override
    public Vehiculo findById(int id) {
        return null;
    }

    @Override
    public void save(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
