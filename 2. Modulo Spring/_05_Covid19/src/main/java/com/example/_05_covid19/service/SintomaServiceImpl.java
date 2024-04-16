package com.example._05_covid19.service;

import com.example._05_covid19.model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaServiceImpl implements ISintomaService{
    private static  List<Sintoma> sintomas;
    static {
        sintomas = new ArrayList<>();
        sintomas.add(new Sintoma(1, "Dolor de cabeza", 5));
        sintomas.add(new Sintoma(2, "Dolor de panza", 1));
        sintomas.add(new Sintoma(3, "Dolor de cuello", 3));
        sintomas.add(new Sintoma(4, "Dolor de espalda", 2));
    }


    @Override
    public List<Sintoma> obtenerSintomas() {
        return sintomas;
    }

    @Override
    public Sintoma obtenerSintoma(String nombre) {
        return sintomas.stream()
                .filter(s->s.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
}
