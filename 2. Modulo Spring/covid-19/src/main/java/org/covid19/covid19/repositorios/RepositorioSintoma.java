package org.covid19.covid19.repositorios;

import lombok.AllArgsConstructor;
import org.covid19.covid19.entidades.Sintoma;

import java.util.List;

@AllArgsConstructor
public class RepositorioSintoma {

    private List<Sintoma> sintomas;

    public List<Sintoma> obtenerSintomas() {
       return this.sintomas;
    }
}
