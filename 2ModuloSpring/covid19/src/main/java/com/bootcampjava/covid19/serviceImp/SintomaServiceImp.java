package com.bootcampjava.covid19.serviceImp;

import com.bootcampjava.covid19.dataBase.SintomaData;
import com.bootcampjava.covid19.model.DTOs.SintomaDTO;
import com.bootcampjava.covid19.model.Sintoma;
import com.bootcampjava.covid19.service.ISintomasService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SintomaServiceImp implements ISintomasService {
    SintomaData dataBaseSintoma = new SintomaData();
    @Override
    public List<Sintoma> obtenerTodosSintomas() {
        dataBaseSintoma.cargarBaseDeDatos(25);
        return dataBaseSintoma.getSintomas();
    }

    @Override
    public SintomaDTO obtenerSintomaPorNombre(String nombre) {
        Sintoma sintoma = dataBaseSintoma.getSintomas().stream().filter(s->s.getNombre().equals(nombre))
                .findFirst().orElse(null);
        if (sintoma != null) return new SintomaDTO(sintoma.getNombre(), sintoma.getNivelDeGravedad());
        return null;
    }


}
