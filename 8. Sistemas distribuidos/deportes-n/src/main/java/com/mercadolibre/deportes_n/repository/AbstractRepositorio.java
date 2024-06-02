package com.mercadolibre.deportes_n.repository;

import java.util.Collection;

public abstract class AbstractRepositorio<C extends Collection, G> {
    private C colleccion;

    public AbstractRepositorio(C colleccion) {
        this.colleccion = colleccion;
    }

    public void add(G object)
    {
        this.colleccion.add(object);
    }

    public C getAll()
    {
        return  this.colleccion;
    }

}
