package com.mercadolibre.Covid19API.services.implementation;

import com.mercadolibre.Covid19API.model.Sintoma;
import com.mercadolibre.Covid19API.repository.RepoBD;
import com.mercadolibre.Covid19API.services.ISintomaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService {
    @Override
    public List<Sintoma> obtSyntomas() {
        return RepoBD.sintomas;
    }

    @Override
    public String obtSyntomaPorNombre(String nombre) {
        Sintoma sintoma = RepoBD.sintomas.stream().filter(s -> s.getNombre().equals(nombre)).findFirst().orElse(null);
        if (sintoma == null)
            return null;
        return sintoma.getNivelGravedad();
    }
}
