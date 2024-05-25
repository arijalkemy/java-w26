package com.example.demo.service;

import com.example.demo.dto.response.PatenteDTO;
import com.example.demo.dto.response.PatenteMarcaDTO;

import java.util.List;

public interface IVehiculoService {

    List<PatenteDTO> listarPatentes();
    List<PatenteMarcaDTO> listarPatenteYMarcaOrdenadosPorAnio();
    List<PatenteDTO> listarPatentesParaVehiculosConRuedasYAnioActual();
}
