package org.example.interfaces;

import java.util.List;

public interface IRepository<T> {
    public void add(T object);
    public T get(int id);
    public List<T> getAll();
    public void put(int id, T object);
    public void delete(int id);
}
