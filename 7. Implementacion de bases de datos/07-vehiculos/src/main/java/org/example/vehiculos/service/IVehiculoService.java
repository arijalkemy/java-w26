package org.example.vehiculos.service;

import org.example.vehiculos.dto.PatenteMarcaDTO;
import org.example.vehiculos.dto.VehiculoDTO;
import org.example.vehiculos.dto.VehiculoSiniestroDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> listarTodasLasPatentes();
    List<VehiculoDTO> listarPatentesYMarcaOrdenadoPorAnio();
    List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio();
    List<VehiculoDTO> listarMatriculaMarcaYModeloConSiniestroMayor();
    List<VehiculoSiniestroDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
