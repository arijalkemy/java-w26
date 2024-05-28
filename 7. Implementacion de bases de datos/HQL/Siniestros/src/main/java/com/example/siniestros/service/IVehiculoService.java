package com.example.siniestros.service;

import com.example.siniestros.dto.PatenteDto;
import com.example.siniestros.dto.PatenteMarcaDto;

import java.util.List;

public interface IVehiculoService {
    List<PatenteDto> getAllPatentes();
    List<PatenteMarcaDto> getAllPatenteMarcaOrderByAnio();
    List<PatenteDto> getAllPatenteFourWheelsAndCurrentYear();
}
