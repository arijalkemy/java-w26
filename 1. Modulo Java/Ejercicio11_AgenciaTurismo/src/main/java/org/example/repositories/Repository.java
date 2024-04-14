package org.example.repositories;

import org.example.bd.BaseDeDatos;

import java.util.List;

public abstract class Repository <T>{

    protected BaseDeDatos baseDeDatos = BaseDeDatos.getBaseDeDatos();

    public abstract T agregar(T dato);
    public abstract List<T> getObjetos();
    public abstract void actualizar(T dato);

}
