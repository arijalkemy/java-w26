package com.bootcamp.vehiculo.mapper;

import com.bootcamp.vehiculo.dto.SiniestroDTO;
import com.bootcamp.vehiculo.model.Siniestro;
import com.bootcamp.vehiculo.model.Vehiculo;
import org.modelmapper.ModelMapper;

public class SiniestroMapper {

    private SiniestroMapper() {}

    public static Siniestro siniestroDTOToSiniestro(SiniestroDTO siniestroDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Siniestro siniestro = modelMapper.map(siniestroDTO, Siniestro.class);

        if (siniestroDTO.getVehiculoId() != null) {
            siniestro.setVehiculo(Vehiculo.builder().id(siniestroDTO.getVehiculoId()).build());
        }

        return siniestro;
    }

    public static SiniestroDTO siniestroToSiniestroDTO(Siniestro siniestro) {
        ModelMapper modelMapper = new ModelMapper();
        SiniestroDTO siniestroDTO = modelMapper.map(siniestro, SiniestroDTO.class);

        if (siniestro.getVehiculo() != null)
            siniestroDTO.setVehiculoId(siniestro.getVehiculo().getId());

        return siniestroDTO;
    }

}
