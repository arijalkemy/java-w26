package org.ggomezr.covid19.application.service.impl;

import org.ggomezr.covid19.application.service.interfaces.ISintomaService;
import org.ggomezr.covid19.domain.entity.Persona;
import org.ggomezr.covid19.domain.entity.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SintomaService implements ISintomaService {

    List<Persona> personas = Arrays.asList(
            new Persona(1, "Geraldine", "Gomez", 20),
            new Persona(2, "Andres", "Lopez", 64),
            new Persona(3, "Margarita", "Rodriguez", 67)
    );
    List<Sintoma> sintomas = Arrays.asList(
            new Sintoma(1, "Fiebre", 2, personas.get(0).getId()),
            new Sintoma(2, "Fatiga", 1, personas.get(1).getId()),
            new Sintoma(3, "Vomito", 4, personas.get(2).getId()),
            new Sintoma(4, "Dificultad para respirar", 4, personas.get(1).getId()),
            new Sintoma(5, "Dolores musculares", 2, personas.get(2).getId())
            );;

    @Override
    public List<Sintoma> findAllSymptoms() {
        return sintomas;
    }

    @Override
    public String findSymptom(String name) {
        Sintoma sintomaEncontrado = sintomas.stream().filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
        return "Nivel de gravedad de " + sintomaEncontrado.getNombre() + ": " + sintomaEncontrado.getNivelDeGravedad();
    }
}
