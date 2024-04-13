package com.example.interfaces;

import java.util.List;
import java.util.Optional;

public interface ICrud <T> {

    public void save(T object);
    public void show(T object);
    public Optional<T> get (String id);
    public void delete(String id);
    public List<T> getAll();


}
