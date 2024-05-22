package org.example.vehiculohql.service;

import org.example.vehiculohql.dto.VehiculoPatenteMarcaDTO;

import java.util.List;


public interface IVehiculoService {
    List<String> getAllPatentes();

    List<VehiculoPatenteMarcaDTO> getVehiculosOrdenados();
}
