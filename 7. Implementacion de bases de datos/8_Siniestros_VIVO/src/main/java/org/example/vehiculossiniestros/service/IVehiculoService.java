package org.example.vehiculossiniestros.service;

import org.example.vehiculossiniestros.dto.PatenteAndMarcaDTO;
import org.example.vehiculossiniestros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<String> getPatentesFromAllVehiculos();
    List<PatenteAndMarcaDTO> getPatenteAndMarcaFromVehiculoOrderByAnio();
}
