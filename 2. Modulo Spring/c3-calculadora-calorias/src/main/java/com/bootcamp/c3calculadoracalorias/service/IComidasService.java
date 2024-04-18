package com.bootcamp.c3calculadoracalorias.service;

import com.bootcamp.c3calculadoracalorias.dto.PlatoDTO;
import org.springframework.stereotype.Service;

@Service
public interface IComidasService {
    Integer caloriasPlato(PlatoDTO plato);
}
