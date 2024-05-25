package com.example.demo.service;

import com.example.demo.dto.VehiculoDTO;
import com.example.demo.dto.VehiculoSiniestroDTO;

import java.util.List;

public interface ISiniestroService {

    List<VehiculoDTO> listarPerdidaMayor10000();
    List<VehiculoSiniestroDTO> listarPerdidaMayor10000Total();
}
