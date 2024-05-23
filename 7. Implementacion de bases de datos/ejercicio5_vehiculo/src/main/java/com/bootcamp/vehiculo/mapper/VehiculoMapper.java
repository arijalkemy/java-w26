package com.bootcamp.vehiculo.mapper;

import com.bootcamp.vehiculo.dto.VehiculoDTO;
import com.bootcamp.vehiculo.model.Vehiculo;

import java.util.List;

public class VehiculoMapper {

    public static List<VehiculoDTO> mapPatenteYMarcaALista(List<Vehiculo> vehiculos) {
        return vehiculos.stream().map(
                        vehiculo -> VehiculoDTO.builder()
                                .patente(vehiculo.getPatente())
                                .marca(vehiculo.getMarca())
                                .build())
                .toList();
    }

}
