package com.mercadolibre.seguro_autos.service;

import java.util.List;

import com.mercadolibre.seguro_autos.dto.ModeloDto;
import com.mercadolibre.seguro_autos.dto.PatenteMarcaDto;
import com.mercadolibre.seguro_autos.dto.PatentesDto;
import com.mercadolibre.seguro_autos.dto.SiniestroDto;

public interface IVehicleService {
    List<PatentesDto> getAllPatentes();
    List<PatenteMarcaDto> getAllPatentesByYear();
    List<PatentesDto> getAllPatentesCuatroRuedasActuales();
    List<ModeloDto> findAllByPerdidaEconomica();
    List<SiniestroDto> findAllByPerdidaEconomicaExtended();
}
