package co.com.mercadolibre.covid.repository;

import co.com.mercadolibre.covid.entity.Sintoma;

import java.util.List;
import java.util.Optional;

public interface ISintomaRepository {

    List<Sintoma> buscarTodos();
    Optional<Sintoma> buscarPorNombre(String nombre);
}
