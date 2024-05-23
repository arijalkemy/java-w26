package org.example.ejercicios_extra_bd_relacional.service;

import org.example.ejercicios_extra_bd_relacional.dto.PrendaDto;
import org.example.ejercicios_extra_bd_relacional.dto.PrendaRequestDto;

import java.util.List;

public interface IPrendaService {

    PrendaDto crearPrenda(PrendaRequestDto prendaRequestDto);
    List<PrendaDto> buscarTodasLasPrendas();
    PrendaDto buscarPrendaPorId(Long idPrenda);
    PrendaDto actualizarPrendaPorId(Long idPrenda, PrendaRequestDto prendaRequestDto);
    void eliminarPrendaPorId(Long idPrenda);
    List<PrendaDto> buscarPrendasPorTamaño(String talle);
    List<PrendaDto> buscarPrendasPorNombre(String nombre);
}
