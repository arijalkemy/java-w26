package co.com.mercadolibre.covid.repository.impl;

import co.com.mercadolibre.covid.entity.Sintoma;
import co.com.mercadolibre.covid.repository.ISintomaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository implements ISintomaRepository {

    @Override
    public List<Sintoma> buscarTodos() {
        return this.devolverLista();
    }

    @Override
    public Optional<Sintoma> buscarPorNombre(String nombre) {
        Optional<Sintoma> sintoma = this.devolverLista().stream().filter(x -> x.getNombre().equals(nombre)).findFirst();
        return sintoma;
    }

    private List<Sintoma> devolverLista() {
        List<Sintoma> sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("S001", "Fiebre", "Moderado"));
        sintomas.add(new Sintoma("S002", "Tos persistente", "Alto"));
        sintomas.add(new Sintoma("S003", "Dolor de cabeza intenso", "Severo"));
        sintomas.add(new Sintoma("S004", "Dificultad para respirar", "Crítico"));
        sintomas.add(new Sintoma("S005", "Dolor abdominal agudo", "Moderado"));

        return sintomas;
    }
}
