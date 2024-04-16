package bootcamp.spring.covid.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.spring.covid.enums.NivelDeGravedad;
import bootcamp.spring.covid.models.Sintoma;

@Repository
public class SintomasRepository {

    private static final List<Sintoma> SINTOMAS = List.of(
            new Sintoma(1, "dolor", NivelDeGravedad.ALTO.name()),
            new Sintoma(2, "vomitos", NivelDeGravedad.MEDIO.name()),
            new Sintoma(3, "cansancio", NivelDeGravedad.BAJO.name()));

    public List<Sintoma> getAll() {
        return SINTOMAS;
    }

    public Optional<Sintoma> find(String nombreSintoma) {

        return SINTOMAS
                .stream()
                .filter(sintoma -> sintoma.getNombre().equals(nombreSintoma))
                .findFirst();
    }
}
