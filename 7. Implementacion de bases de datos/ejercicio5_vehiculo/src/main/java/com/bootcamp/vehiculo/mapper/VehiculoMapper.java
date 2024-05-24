package com.bootcamp.vehiculo.mapper;

import com.bootcamp.vehiculo.dto.VehiculoDTO;
import com.bootcamp.vehiculo.model.Vehiculo;
import org.modelmapper.ModelMapper;

import java.util.List;

public class VehiculoMapper {

    public static Vehiculo vehiculoDTOToVehiculo(VehiculoDTO vehiculoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehiculoDTO, Vehiculo.class);
    }

    public static VehiculoDTO vehiculoToVehiculoDTO(Vehiculo vehiculo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    public static List<VehiculoDTO> mapPatenteYMarcaALista(List<Vehiculo> vehiculos) {
        return vehiculos.stream().map(
                        vehiculo -> VehiculoDTO.builder()
                                .patente(vehiculo.getPatente())
                                .marca(vehiculo.getMarca())
                                .build())
                .toList();
    }

}
