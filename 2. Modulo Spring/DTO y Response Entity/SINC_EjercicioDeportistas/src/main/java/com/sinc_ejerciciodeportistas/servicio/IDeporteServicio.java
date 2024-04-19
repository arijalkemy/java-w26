package com.sinc_ejerciciodeportistas.servicio;

import com.sinc_ejerciciodeportistas.dto.DeporteDTO;
import com.sinc_ejerciciodeportistas.entidades.Deporte;

import java.util.List;

public interface IDeporteServicio {
    List<DeporteDTO> obtenerTodosLosDeportes();

    String buscarDeportePorNombre(String nombreDeporte);


}
