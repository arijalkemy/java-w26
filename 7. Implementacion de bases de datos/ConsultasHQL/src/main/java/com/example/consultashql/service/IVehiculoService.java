package com.example.consultashql.service;

import com.example.consultashql.dto.ResponsePatenteAndMarcaDTO;
import com.example.consultashql.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    Vehiculo save(Vehiculo vehiculo);
    List<Vehiculo> getAll();
    List<String> getPatente();
    List<ResponsePatenteAndMarcaDTO> getPatenteAndMarca();
}
