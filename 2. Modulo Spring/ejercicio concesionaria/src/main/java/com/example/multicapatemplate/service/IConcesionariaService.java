package com.example.multicapatemplate.service;

import com.example.multicapatemplate.dto.VehiculoDto;
import com.example.multicapatemplate.model.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaService {

    List<VehiculoDto> getAll();


    void save(Vehiculo vehiculo);

    List<VehiculoDto> getAll( LocalDate fechaDesde, LocalDate fechaHasta);

    List<VehiculoDto> getAll(double precioDesde, double precioHasta);

    VehiculoDto getVehiculoByPlaca(String placa);
}
