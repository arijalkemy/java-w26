package com.meli.obrasliterarias.service;

import com.meli.obrasliterarias.dto.ObrasLiterariasDTO;
import com.meli.obrasliterarias.dto.ResponseDTO;
import java.util.List;

public interface IObrasService {
    ResponseDTO createObra(ObrasLiterariasDTO obra);

    List<ObrasLiterariasDTO> listObrasByAutor (String nombre);
}
