package co.com.mercadolibre.siniestros.service;

import co.com.mercadolibre.siniestros.dto.PatenteMarcaDTO;
import co.com.mercadolibre.siniestros.dto.ResponseDTO;
import co.com.mercadolibre.siniestros.dto.SumaDTO;

import java.util.List;

public interface IVehiculoService {

    List<String> listarTodasLasPatentes();
    List<PatenteMarcaDTO> listarPatentesYMarcaOrdenadoPorAnio();
    List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio();
    List<ResponseDTO> listarMatriculaMarcaYModeloConSiniestroMayor();
    List<SumaDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor();
}
