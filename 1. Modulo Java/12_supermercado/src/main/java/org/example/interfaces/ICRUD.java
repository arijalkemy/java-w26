package org.example.interfaces;

import java.util.List;

public interface ICRUD<T> {

    void create(T obj);
    T search(Number id);
    void update(T obj);
    void delete(Number id);
    List<T> getAll();

}
