package org.example.ejercicios_extra_elasticsearch.service;

import org.example.ejercicios_extra_elasticsearch.dto.PrendaDto;
import org.example.ejercicios_extra_elasticsearch.dto.PrendaRequestDto;

import java.util.List;

public interface IPrendaService {

    PrendaDto crearPrenda(PrendaRequestDto prendaRequestDto);
    List<PrendaDto> buscarTodasLasPrendas();
    PrendaDto buscarPrendaPorId(String idPrenda);
    PrendaDto actualizarPrendaPorId(String idPrenda, PrendaRequestDto prendaRequestDto);
    void eliminarPrendaPorId(String idPrenda);
    List<PrendaDto> buscarPrendasPorTamaño(String talle);
    List<PrendaDto> buscarPrendasPorNombre(String nombre);
}
