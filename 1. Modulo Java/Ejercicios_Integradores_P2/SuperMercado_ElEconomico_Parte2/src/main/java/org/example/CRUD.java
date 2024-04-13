package org.example;

import java.util.List;

public interface CRUD<T> {
    void create(T t);
    T read(String id);
    void update(T t);
    void delete(String id);
    List<T> getAll();
}