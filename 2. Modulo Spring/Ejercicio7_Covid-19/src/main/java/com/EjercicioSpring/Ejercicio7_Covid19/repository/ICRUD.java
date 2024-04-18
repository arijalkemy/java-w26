package com.EjercicioSpring.Ejercicio7_Covid19.repository;

import com.EjercicioSpring.Ejercicio7_Covid19.baseDeDatos.BaseDeDatos;

import java.util.List;

public interface ICRUD<T> {

    static final BaseDeDatos baseDeDatos = BaseDeDatos.getBaseDeDatos();

    public void create(T t);
    public List<T> getAll();
}
