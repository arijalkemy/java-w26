package com.example.covid.servicios.impl;

import com.example.covid.modelo.Sintoma;
import com.example.covid.servicios.ISintomasService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SintomasServiceImpl implements ISintomasService {

    List<Sintoma> sintomaList = new ArrayList<>();

    public SintomasServiceImpl() {
        Sintoma fiebre = new Sintoma(1,"Fiebre",4);
        Sintoma tos = new Sintoma(2, "Tos", 3);
        Sintoma dolorDeCabeza = new Sintoma(3, "Dolor de cabeza", 2);

        sintomaList.addAll(List.of(fiebre,tos,dolorDeCabeza));
    }

    @Override
    public List<Sintoma> obtenerTodos() {
        return sintomaList;
    }

    @Override
    public Optional<Sintoma> obtenerSintomaDadoElNombre(String nombre) {
        return sintomaList
                .stream()
                .filter(
                        s -> s.getNombre().equalsIgnoreCase(nombre)
                )
                .findFirst();
    }
}
