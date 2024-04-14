package org.example.repositories;

import org.example.baseDeDatos.BaseDatos;

import java.util.List;

public interface ICRUD <T, U> {

    static final BaseDatos baseDeDatos = BaseDatos.getBaseDatos();

    public T create(T t);
    public List<T> read();
    public T update(T t);
    public T delete(T t);
    public T getByID(U u);

}
