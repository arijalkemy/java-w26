package com.meli.joyeria.service;

import com.meli.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    public String crearJoya(Joya joya);
    public List<Joya> devolverJoyas();
    public String borrarJoyaLogica(Long id);
    public Joya actualizarJoya(Long id, Joya joya);
    public Joya obtenerJoyaPorId(Long id);
}
