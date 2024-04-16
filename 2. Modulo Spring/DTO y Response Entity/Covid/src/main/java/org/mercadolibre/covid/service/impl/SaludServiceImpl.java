package org.mercadolibre.covid.service.impl;

import org.mercadolibre.covid.dto.PersonaDTO;
import org.mercadolibre.covid.entity.Sintoma;
import org.mercadolibre.covid.repository.SaludRepositorio;
import org.mercadolibre.covid.service.ISaludService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaludServiceImpl implements ISaludService {

    final SaludRepositorio saludRepositorio = new SaludRepositorio();
    @Override
    public List<Sintoma> getSintomas() {
        return saludRepositorio.getListaDeSintomas();
    }

    @Override
    public int getGravedadDeSintoma(String nombreSintoma) {
        Sintoma sintoma = saludRepositorio.getSintoma(nombreSintoma);
        if (sintoma != null){
            return sintoma.getNivelDeGravedad();
        }
        return -1;
    }

    @Override
    public List<PersonaDTO> getPersonasDeRiesgo() {
        return saludRepositorio.getPersonasDeRiesgo();
    }

}
