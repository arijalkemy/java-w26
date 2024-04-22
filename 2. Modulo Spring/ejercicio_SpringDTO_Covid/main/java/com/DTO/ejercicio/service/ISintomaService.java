package com.DTO.ejercicio.service;

import com.DTO.ejercicio.persistence.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISintomaService {

    public List<Sintoma> getSintomas();
}
