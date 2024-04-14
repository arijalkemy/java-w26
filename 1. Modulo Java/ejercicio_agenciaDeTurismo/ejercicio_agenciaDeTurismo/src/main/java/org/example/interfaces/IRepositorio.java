package org.example.interfaces;

public interface IRepositorio<T> {
    public void Add(T item);

    public T findOne(int id);
}
