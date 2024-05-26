package org.example.hqlvivo.Service;

import org.example.hqlvivo.DTOs.Request.CreateVehiculoRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.VehiculoResponseDto;

import java.util.List;

public interface IVehiculoService {
    VehiculoResponseDto create(CreateVehiculoRequestDto vehiculo);
    List<VehiculoResponseDto> searchAll();
    List<String> searchAllPlates();
    List<PatenteMarcaModeloResponseDto> searchAllPatenteMarcaOrderAsc();
    List<String> searchAllPatentesByAnioAndMoreThanFourRuedas(Integer anio);

}
