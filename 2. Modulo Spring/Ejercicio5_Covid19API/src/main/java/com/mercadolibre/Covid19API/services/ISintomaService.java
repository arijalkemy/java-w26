package com.mercadolibre.Covid19API.services;

import com.mercadolibre.Covid19API.model.Sintoma;

import java.util.List;

public interface ISintomaService {
    public List<Sintoma> obtSyntomas();
    public String obtSyntomaPorNombre(String nombre);
}
