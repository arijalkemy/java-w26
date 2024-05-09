package com.deportista.demo.servicios;

import com.deportista.demo.dto.DTODeportista;
import com.deportista.demo.modelo.Deporte;

import java.util.List;

public interface IServicioDeportista {
    public List<Deporte> listarDeportes();
    public Deporte obtenerDeporte(String deporte);
    public List<DTODeportista> listarDTOdeportista();
}
