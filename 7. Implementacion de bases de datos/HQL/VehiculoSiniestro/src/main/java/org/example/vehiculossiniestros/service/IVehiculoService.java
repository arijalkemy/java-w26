package org.example.vehiculossiniestros.service;

import org.example.vehiculossiniestros.dto.PatenteMarcaDTO;
import org.example.vehiculossiniestros.dto.PatenteMarcaModeloDTO;
import org.example.vehiculossiniestros.dto.VehiculoSiniestroDTO;

import java.util.List;

public interface IVehiculoService {
    List<String> getPatentesFromAllVehiculos();
    List<PatenteMarcaDTO> getPatenteAndMarcaFromVehiculoOrderByAnio();
    List<String> getPatenteFromVehiculosWithMoreThan4WheelsAndManufacturedThisYear();
    List<PatenteMarcaModeloDTO> getPatenteMarcaModeloWhereSiniestroIsBig();
    List<VehiculoSiniestroDTO> getPatenteMarcaModeloAndTotalLossWhereSiniestroIsBig();
}
