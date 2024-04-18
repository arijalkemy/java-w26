package com.meli.bootcamp.blog.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository <T>{
    public void add(T entity);
    public List<T> getAll();
    public Optional<T> findById(Integer id);
}
