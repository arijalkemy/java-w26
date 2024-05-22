package org.example.apiobrasliterarias.service;

import org.example.apiobrasliterarias.DTO.ResposeObraLiterariaDTO;

import java.util.List;

public interface IObraLiterariaService {
    List<ResposeObraLiterariaDTO> getByAutor(String autor);
    List<ResposeObraLiterariaDTO> getByKeyword(String keyword);
    List<ResposeObraLiterariaDTO> getTopFiveByPages();
    List<ResposeObraLiterariaDTO> getByBeforeYear(int year);
    List<ResposeObraLiterariaDTO> getByEditorial(String editorial);
}
