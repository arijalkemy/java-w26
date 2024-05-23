package com.bootcamp.vehiculo.service;

import com.bootcamp.vehiculo.dto.ResponseDTO;
import com.bootcamp.vehiculo.dto.SiniestroDTO;
import com.bootcamp.vehiculo.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {
    List<String> getAllPatentes();

    List<VehiculoDTO> getPatentesYMarcaOrdenadoPorAnio();

    List<String> getPatentesByCuatroRuedasYAnioCorriente();

    VehiculoDTO getMatriculaMarcaModeloPerdidaMayorA(int i);

    ResponseDTO postVehiculo(VehiculoDTO vehiculoDTO);

    ResponseDTO postSiniestro(Long vehiculoId, SiniestroDTO siniestroDTO);

}
