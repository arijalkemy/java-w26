package com.EjercicioSpring.Ejercicio7_Covid19.repository;

import com.EjercicioSpring.Ejercicio7_Covid19.entity.Sintoma;

import java.util.List;

public class SintomaRepository implements ICRUD<Sintoma>{
    @Override
    public void create(Sintoma sintoma) {

    }

    @Override
    public List<Sintoma> getAll() {
        return baseDeDatos.getSintomas();
    }
}
