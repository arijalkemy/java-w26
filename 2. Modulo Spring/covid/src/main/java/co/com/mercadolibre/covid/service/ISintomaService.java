package co.com.mercadolibre.covid.service;

import co.com.mercadolibre.covid.entity.Sintoma;

import java.util.List;

public interface ISintomaService {

    List<Sintoma> buscarTodos();
    Sintoma buscarPorNombre(String nombre);
}
