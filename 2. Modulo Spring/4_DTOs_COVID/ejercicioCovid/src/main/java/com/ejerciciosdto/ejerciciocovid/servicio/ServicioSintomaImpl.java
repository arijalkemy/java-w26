package com.ejerciciosdto.ejerciciocovid.servicio;

import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;
import com.ejerciciosdto.ejerciciocovid.repositorio.CreadorInstancias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioSintomaImpl implements IServicioSintoma{
    CreadorInstancias creador = new CreadorInstancias();
    @Override
    public List<Sintoma> getSintomas() {
        return creador.getSintomas();
    }

    @Override
    public ResponseEntity getSintomas(String name) {
        Sintoma response = creador.getSintomas().stream().filter(e -> name.equals(e.getNombre())).findFirst().orElse(null);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>( "El nivel de gravedad es: " + response.getNivel_de_gravedad(), HttpStatus.OK);
    }
}
