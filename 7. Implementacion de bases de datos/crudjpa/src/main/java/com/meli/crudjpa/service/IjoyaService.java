package com.meli.crudjpa.service;

import com.meli.crudjpa.model.DTO.JoyaDTO;
import com.meli.crudjpa.model.Joya;

import java.util.List;

public interface IjoyaService {
    String crearJoya(JoyaDTO joya);
    String actualizarJoya(int id,JoyaDTO joya);
    String eliminarJoya(int id);
    JoyaDTO buscarJoyaPorId(int id);
    List<JoyaDTO> buscarTodasLasJoyas();
}
