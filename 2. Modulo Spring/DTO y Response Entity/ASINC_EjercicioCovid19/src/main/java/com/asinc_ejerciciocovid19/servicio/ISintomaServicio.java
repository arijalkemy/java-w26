package com.asinc_ejerciciocovid19.servicio;

import com.asinc_ejerciciocovid19.dto.SintomaDTO;

import java.util.List;

public interface ISintomaServicio {
    List<SintomaDTO> buscarTodosLosSintomas();
    SintomaDTO buscarSintomaPorNombre(String nombre);
}
