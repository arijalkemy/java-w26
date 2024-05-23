package co.com.mercadolibre.siniestros.service;

import co.com.mercadolibre.siniestros.dto.MarcaModeloPatenteDTO;
import co.com.mercadolibre.siniestros.dto.PatenteMarcaDTO;
import co.com.mercadolibre.siniestros.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> listarTodasLasPatentes();
    List<PatenteMarcaDTO> listarPatentesYMarcaOrdenadoPorAnio();
    List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio();
    List<VehiculoDTO> listarMatriculaMarcaYModeloConSiniestroMayor();
    List<VehiculoDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
