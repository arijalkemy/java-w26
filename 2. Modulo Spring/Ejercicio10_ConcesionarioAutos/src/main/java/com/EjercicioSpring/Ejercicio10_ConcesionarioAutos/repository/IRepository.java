package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.repository;

import com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.baseDeDatos.DataBase;

import java.util.List;
import java.util.Map;

public interface IRepository<T, S> {

    static final DataBase dataBase = DataBase.getDataBase();

    public T addElement(T t);

    public Map<S, T> getAll();

    public T getById(S s);

    public List<T> getAllByForeingId(S s);
}
