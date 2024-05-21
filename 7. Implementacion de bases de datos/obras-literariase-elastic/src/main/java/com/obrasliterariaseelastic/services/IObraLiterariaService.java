package com.obrasliterariaseelastic.services;

import com.obrasliterariaseelastic.DTOs.ObraLiterariaRequestDTO;
import com.obrasliterariaseelastic.models.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {
    public List<ObraLiteraria> guardarTodos(List<ObraLiterariaRequestDTO> obras);

    public List<ObraLiteraria> getObrasByAutor(String autor);

    List<ObraLiteraria> getObrasConPalabrasClaveEnElTitulo(String titulo);

    List<ObraLiteraria> getTop5ConMasPaginas();

    List<ObraLiteraria> getObrasAntesDe(Integer anio);

    List<ObraLiteraria> getObrasByEditorial(String editorial);
}
