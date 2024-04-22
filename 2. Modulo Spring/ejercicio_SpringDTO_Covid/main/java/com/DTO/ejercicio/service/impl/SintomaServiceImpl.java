package com.DTO.ejercicio.service.impl;

import org.springframework.stereotype.Service;
import com.DTO.ejercicio.persistence.Sintoma;
import com.DTO.ejercicio.service.ISintomaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    private List<Sintoma> sintomas;

    public SintomaServiceImpl(){
        sintomas = new ArrayList<>(){{
            add(new Sintoma(12,"Covid",1));
            add(new Sintoma(22,"Dengue",3));
            add(new Sintoma(12,"Cancer",5));
        }};
    }


    @Override
    public List<Sintoma> getSintomas() {
        return sintomas;
    }
}
