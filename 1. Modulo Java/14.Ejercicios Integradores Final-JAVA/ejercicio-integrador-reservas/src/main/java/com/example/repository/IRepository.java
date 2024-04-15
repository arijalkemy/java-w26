package com.example.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {

    public void save(T t);

    public void show(T t);

    public Optional<T> get(String id);

    public void delete(String id);

    public List<T> getAll();

}
