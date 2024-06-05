package org.meli.ejercicio6_p2_d1_joyeria_las_perlas.service;

import org.meli.ejercicio6_p2_d1_joyeria_las_perlas.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {
    public List<JoyaDTO> obtenerListaJoyas();
    public JoyaDTO guardarJoya(JoyaDTO joyaDTO);
    public JoyaDTO modificarJoya(Long id, JoyaDTO joyaDTO);
    public JoyaDTO obtenerJoyaPorId(Long id);
    public JoyaDTO eliminarJoya(Long id);
}
