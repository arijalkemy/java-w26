package com.deportistas.deportistademo.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T>{
    public List<T> findAll();
    public Optional<T> find(String name);
    public void add(T entity);
}
