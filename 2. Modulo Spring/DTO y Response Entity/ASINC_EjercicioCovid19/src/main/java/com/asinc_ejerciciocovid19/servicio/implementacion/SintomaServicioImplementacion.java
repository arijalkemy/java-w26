package com.asinc_ejerciciocovid19.servicio.implementacion;

import com.asinc_ejerciciocovid19.dto.SintomaDTO;
import com.asinc_ejerciciocovid19.entidad.Sintoma;
import com.asinc_ejerciciocovid19.repositorio.Repositorio;
import com.asinc_ejerciciocovid19.servicio.ISintomaServicio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SintomaServicioImplementacion implements ISintomaServicio {
    @Override
    public List<SintomaDTO> buscarTodosLosSintomas() {
        return Repositorio.listaSintomas.stream().map(s -> convertirSintomaADTO(s)).toList();
    }

    @Override
    public SintomaDTO buscarSintomaPorNombre(String nombreSintoma) {
        Sintoma sintoma = Repositorio.listaSintomas.stream()
                        .filter(s -> s.getNombre().equalsIgnoreCase(nombreSintoma))
                        .findFirst()
                        .orElse(null);
        return convertirSintomaADTO(sintoma);
    }

    public SintomaDTO convertirSintomaADTO(Sintoma sintoma) {
        return new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad());
    }
}
