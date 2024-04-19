package com.example.multicapatemplate.repository;

import com.example.multicapatemplate.dto.VehiculoDto;
import com.example.multicapatemplate.model.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaRepository {

    List<Vehiculo> getAll();



    Vehiculo findById(int id);

    void save(Vehiculo vehiculo);
}
