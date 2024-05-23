package org.example.vehiculohql.service;

import org.example.vehiculohql.dto.TotalSiniestroDto;
import org.example.vehiculohql.dto.VehiculoPatenteMarcaDTO;

import java.util.List;


public interface IVehiculoService {
    List<String> getAllPatentes();
    List<VehiculoPatenteMarcaDTO> getVehiculosOrdenados();
    List<String> getPatentesByYear(int anioActual);
    List<VehiculoPatenteMarcaDTO> findAllSiniestro(Double perdida);
    List<TotalSiniestroDto> getTotalSiniestro(Double perdida);
}
