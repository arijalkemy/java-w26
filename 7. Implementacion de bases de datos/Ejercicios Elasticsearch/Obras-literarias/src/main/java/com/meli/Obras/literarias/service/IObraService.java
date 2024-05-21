package com.meli.Obras.literarias.service;

import com.meli.Obras.literarias.dto.ObraDto;

import java.util.List;

public interface IObraService {
    ObraDto crearObra(ObraDto obraDto);

    List<ObraDto> getObrasByAutor(String autor);

    List<ObraDto> getObrasByTitulo(String titulo);

    List<ObraDto> getObrasConMasCantidadDePaginas();

    List<ObraDto> getObrasByFechaPublicacion(int anio);

    List<ObraDto> getObrasByEditorial(String editorial);
}
