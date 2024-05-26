package com.mercadolibre.concesionaria.service;

import com.mercadolibre.concesionaria.dto.PatenteMarcaYModeloVehiculoDTO;
import com.mercadolibre.concesionaria.dto.PatenteVehiculoDTO;
import com.mercadolibre.concesionaria.dto.PatenteYMarcaVehiculoDTO;
import com.mercadolibre.concesionaria.dto.VehiculosConSiniestroMayorA1000;

import java.util.List;
import java.util.Map;

public interface IVehiculoService {
    List<PatenteVehiculoDTO> getAllPatentes();

    List<PatenteYMarcaVehiculoDTO> getAllPatentesYMarcas();

    List<PatenteVehiculoDTO> getPatentesSegunRuedasYAnoDeFabricacion();

    List<PatenteMarcaYModeloVehiculoDTO> getVehiculosConSiniestrosMayoresA10000();

    VehiculosConSiniestroMayorA1000 getConjuntoVehiculosConSiniestrosMayoresA1000();
}
