package org.example.covid19.repository;

import org.example.covid19.entities.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SintomasRepositorio {

    private List<Sintoma> listaDeSintomas = List.of(
            new Sintoma(1, "Temperatura Alta", "Medio"),
            new Sintoma(1, "Dolor fisico", "Medio"),
            new Sintoma(1, "Frio", "Alto")
    );

    public List<Sintoma> getListaDeSintomas() {
        return listaDeSintomas;
    }

    public Optional<Sintoma> buscarSintoma(String nombre) {
        return listaDeSintomas.stream()
                .filter((storedSintoma) ->
                        storedSintoma.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }
}
