package org.example.hqlvivo.Service;

import org.example.hqlvivo.DTOs.Request.CreateSiniestroRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloTotalPerdidaResponseDto;
import org.example.hqlvivo.DTOs.Response.SiniestroResponseDto;

import java.util.List;

public interface ISiniestroService {
    SiniestroResponseDto create(CreateSiniestroRequestDto request);
    List<SiniestroResponseDto> searchAll();
    List<PatenteMarcaModeloResponseDto> searchAllDatosSiniestroWithPerdidaMayorDiezMil();
    List<PatenteMarcaModeloTotalPerdidaResponseDto> searchAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida();
}
