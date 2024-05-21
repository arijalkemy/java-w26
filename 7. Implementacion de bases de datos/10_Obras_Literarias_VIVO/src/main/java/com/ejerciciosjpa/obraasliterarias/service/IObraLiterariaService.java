package com.ejerciciosjpa.obraasliterarias.service;

import com.ejerciciosjpa.obraasliterarias.domain.ObraLiteraria;
import com.ejerciciosjpa.obraasliterarias.dto.RequestObraLiterariaDto;
import com.ejerciciosjpa.obraasliterarias.dto.ResponseObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {
    ResponseObraLiterariaDto create(RequestObraLiterariaDto request);
    List<ObraLiteraria> findAll();
    List<ResponseObraLiterariaDto> findObraById(String nombre);
    List<ResponseObraLiterariaDto> findObraByClave(String clave);
    List<ResponseObraLiterariaDto> findTopObrasByLength();
    List<ResponseObraLiterariaDto> findObrasBefore(Integer year);
    List<ResponseObraLiterariaDto> findObrasByEditorial(String editorial);
}
