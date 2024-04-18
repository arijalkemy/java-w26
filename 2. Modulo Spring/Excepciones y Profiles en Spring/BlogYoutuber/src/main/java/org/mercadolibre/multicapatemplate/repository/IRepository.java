package org.mercadolibre.multicapatemplate.repository;

import java.util.List;

public interface IRepository<T> {
    public List<T> findAll();
    public int save(T object);
}
