package com.ejerciciosdto.ejerciciocovid.servicio;

import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServicioSintoma {
    public List<Sintoma> getSintomas();
    public ResponseEntity getSintomas(String name);
}
