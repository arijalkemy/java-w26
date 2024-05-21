package com.meli.PracticaHQL.service;

import com.meli.PracticaHQL.dto.PatenteDto;
import com.meli.PracticaHQL.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<PatenteDto> getPatentes();

    List<PatenteDto> getPatentesYMarcas();

    List<String> getVehiculosConCuatroRuedas();

    Vehiculo save(Vehiculo vehiculo);
}
