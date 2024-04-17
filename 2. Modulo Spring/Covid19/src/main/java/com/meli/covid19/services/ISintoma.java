package com.meli.covid19.services;
import com.meli.covid19.dto.SintomaDTO;

import java.util.List;

public interface ISintoma {

    public List<SintomaDTO> verSintomas();
    public String buscarSintoma(String nombre);
}
